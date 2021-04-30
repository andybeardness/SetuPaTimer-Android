package com.beardness.setupatimer.Codez.Helperz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beardness.setupatimer.Codez.Databasez.JokeDB;
import com.beardness.setupatimer.Codez.Factoriez.ListenerFactory;
import com.beardness.setupatimer.R;

public class RecyclerJokesAdapter extends RecyclerView.Adapter<RecyclerJokesAdapter.JokeViewHolder> {
  
  private String type;
  
  public RecyclerJokesAdapter(String type) {
    this.type = type;
  }
  
  @NonNull
  @Override
  public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_view, parent, false);
    JokeViewHolder viewHolder = new JokeViewHolder(view);
    viewHolder.itemView.setOnClickListener(ListenerFactory.getJokeItemListener(viewHolder, this));
    
    return viewHolder;
  }
  
  @Override
  public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
    if (!JokeDB.cursor().moveToPosition(position)) {
      return;
    }
    
    int status = JokeDB.cursor().getInt(JokeDB.cursor().getColumnIndex(JokeDB.COL_STATUS));
    int isFavorite = JokeDB.cursor().getInt(JokeDB.cursor().getColumnIndex(JokeDB.COL_IS_FAVORITE));
  
    holder.cuttedSetUp.setText(JokeDB.cursor().getString(JokeDB.cursor().getColumnIndex(JokeDB.COL_CUTTED)));
  
    holder.bind(status, isFavorite);
  }
  
  @Override
  public int getItemCount() {
    return JokeDB.cursor().getCount();
  }
  
  public void updateCursor(Context context) {
    JokeDB.updateDB(context);
    JokeDB.updateListJokesCursor(type);
  }
  
  public class JokeViewHolder extends RecyclerView.ViewHolder {
    
    public TextView cuttedSetUp;
  
    public JokeViewHolder(@NonNull View itemView) {
      super(itemView);
      cuttedSetUp = itemView.findViewById(R.id.cutted_set_up);
    }
    
    public void bind(int status, int isFavorite) {
      if (isFavorite == 1) {
        itemView.setBackgroundResource(R.drawable.border_filled_red);
      }
      else {
        if (status == 0) {
          itemView.setBackgroundResource(R.drawable.border_filled_white);
        }
        else if (status == 1) {
          itemView.setBackgroundResource(R.drawable.border_filled_yellow);
        }
        else if (status == 2) {
          itemView.setBackgroundResource(R.drawable.border_filled_green);
        }
      }
      
    }
    
  }
  
}
