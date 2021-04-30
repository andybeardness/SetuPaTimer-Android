package com.beardness.setupatimer.Codez.Databasez;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class JokeDB extends SQLiteOpenHelper {
  
  public static final String DB_NAME = "JOKES";
  public static final int DB_VERSION = 1;
  
  public static final int STATUS_NEW = 0;
  public static final int STATUS_SET_UP_WATCHED = 1;
  public static final int STATUS_PUNCHLINE_WATCHED = 2;
  
  public static final String COL_ID = "_id";
  public static final String COL_SET_UP = "SET_UP";
  public static final String COL_CUTTED = "CUTTED";
  public static final String COL_PUNCHLINE = "PUNCHLINE";
  public static final String COL_STATUS = "STATUS";
  public static final String COL_IS_FAVORITE = "IS_FAVORITE";
  
  public static final String CURSOR_TYPE_ALL = "ALL";
  public static final String CURSOR_TYPE_WATCHED = "WATCHED";
  public static final String CURSOR_TYPE_FAVORITE = "FAVORITE";
  public static final String CURSOR_TYPE_UNWATCHED = "UNWATCHED";
  
  private static SQLiteOpenHelper db;
  private static SQLiteDatabase data;
  private static Cursor cursor;
  
  private static final int cutter = 25;
  private static final String separator = "...";
  
  // -----------------------------------------------
  // DB SETTINGS
  // -----------------------------------------------
  
  private JokeDB(@Nullable Context context,
                 @Nullable String name,
                 @Nullable SQLiteDatabase.CursorFactory factory,
                 int version) {
    super(context, DB_NAME, null, DB_VERSION);
  }
  
  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + DB_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_SET_UP + " TEXT, " +
            COL_CUTTED + " TEXT, " +
            COL_PUNCHLINE + " TEXT, " +
            COL_STATUS + " INTEGER, " +
            COL_IS_FAVORITE + " INTEGER " +
            ");"
    );
    
    initialInsertRow(db, "Кто ведет самую активную половую жизнь в школе?", "Уборщица", STATUS_NEW, false);
    initialInsertRow(db, "Как черная женщина может понять, что её ниггер нашёл другую?", "По следам чужой помады на его кулаках", STATUS_NEW, false);
    initialInsertRow(db, "Как заставить Тимати сосать один член?", "Вынуть второй", STATUS_NEW, false);
    initialInsertRow(db, "Почему сперма дороже крови?", "Потому что ручная работа", STATUS_NEW, false);
    initialInsertRow(db, "Новый айфон, как твоя бывшая...", "Уродливый конечно, но три рабочие дырки - это три рабочие дырки", STATUS_NEW, false);
    initialInsertRow(db, "Как правильно использовать рваный презерватив?", "Гонять его в аптеку за нормальными", STATUS_NEW, false);
    initialInsertRow(db, "Ты конечно, не Венера...", "Но что-то венерическое в тебе есть...", STATUS_NEW, false);
    initialInsertRow(db, "Что сказала мать своему сыну - майнкрафтеру?", "Закругляйся", STATUS_NEW, false);
    initialInsertRow(db, "В чем разница между Тимати и котом?", "Кот лижет только свои яйца", STATUS_NEW, false);
    initialInsertRow(db, "Что общего у Тимати и ламборджини?", "Быстрая задняя передача", STATUS_NEW, false);
    initialInsertRow(db, "Пришёл к другу на похороны и спросил...", "Че молчишь как вкопанный?", STATUS_NEW, false);
    initialInsertRow(db, "Как обрюхатить монашку?", "Переодеть ее в мальчика из церковного хора", STATUS_NEW, false);
    initialInsertRow(db, "Какие комментарии будут доминировать на YouTube перед концом света?", "«последний нах»", STATUS_NEW, false);
    initialInsertRow(db, "Для чего в кошельке лежит презерватив?", "На влажный случай", STATUS_NEW, false);
    initialInsertRow(db, "Что будет если ударить ребёнка по попе?", "Стояк", STATUS_NEW, false);
    initialInsertRow(db, "Почему у репера Карандаша нет детей?", "Потому, что у него на конце резинка", STATUS_NEW, false);
    initialInsertRow(db, "Почему нельзя кончать на шею женщине?", "Потому что дети не должны сидеть на шее у родителей", STATUS_NEW, false);
    initialInsertRow(db, "Что сделал Гуф когда слез с иглы?", "Сел на хуй Собянина", STATUS_NEW, false);
    initialInsertRow(db, "Как называют мента играющего в маинкрафт?", "Рудокоп", STATUS_NEW, false);
    initialInsertRow(db, "Как называют сборную Белоруссии по футболу?", "Тима Белорусских", STATUS_NEW, false);
    initialInsertRow(db, "Что общего у Яндекс еды и оргазма в сексе?", "И там и там могут не доставить", STATUS_NEW, false);
    initialInsertRow(db, "Как называют человека, который продал свою печень?", "Обеспеченный.", STATUS_NEW, false);
    initialInsertRow(db, "Почему шутить можно над всеми, кроме безногих?", "Шутки про них обычно не заходят", STATUS_NEW, false);
    initialInsertRow(db, "Почему безногий боится гопников?", "Не может постоять за себя", STATUS_NEW, false);
    initialInsertRow(db, "Почему толстых женщин не берут в стриптиз?", "Они перегибают палку", STATUS_NEW, false);
    initialInsertRow(db, "Почему в Африке так много болезней?", "Потому что таблетки нужно запивать водой", STATUS_NEW, false);
    initialInsertRow(db, "Что сказал слепой, войдя в бар?", "\"Всем привет, кого не видел\"", STATUS_NEW, false);
    initialInsertRow(db, "Зачем скачивать порно-ролик с карликом?", "Он занимает меньше места", STATUS_NEW, false);
    initialInsertRow(db, "Как называется избушка Бабы-Яги лесбиянки?", "Лисбушка", STATUS_NEW, false);
    initialInsertRow(db, "Как предотвратить инцест у грибов?", "Фразой \"Не спорь с матерью!\"", STATUS_NEW, false);
    initialInsertRow(db, "Чего общего у некрофила и владельца строительной кампании?", "Они оба имеют недвижимость", STATUS_NEW, false);
    initialInsertRow(db, "Почему наркоманы могут получить Нобелевскую премию по физике?", "Они знают как измерять скорость в граммах", STATUS_NEW, false);
    initialInsertRow(db, "Как называют черную женщину сделавшую шесть абортов?", "Борец с преступностью", STATUS_NEW, false);
    initialInsertRow(db, "Из-за чего порвался косоглазый?", "Пошел куда глаза глядят", STATUS_NEW, false);
    initialInsertRow(db, "Почему среди немых не популярен БДСМ?", "У них нет стоп слова", STATUS_NEW, false);
    initialInsertRow(db, "Алло, это Чешская Республика?", "Почешите мне спинку", STATUS_NEW, false);
    initialInsertRow(db, "Что говорят про некрофила-зануду?", "Заебет мертвого", STATUS_NEW, false);
    initialInsertRow(db, "Почему среди фигуристов, не бывает цыган?", "Никто не верит что это их конёк", STATUS_NEW, false);
    initialInsertRow(db, "Почему цыган не отправляют на олимпиаду?", "Они заберут все золото", STATUS_NEW, false);
    initialInsertRow(db, "Как называется притон наркоманов-закладчиков?", "Клуб весёлых и находчивых", STATUS_NEW, false);
    initialInsertRow(db, "В чем разница между землей и нашими шутками?", "Земля не плоская", STATUS_NEW, false);
    initialInsertRow(db, "Почему евреи не делают репосты?", "У них нет кнопки поделиться", STATUS_NEW, false);
    initialInsertRow(db, "Чего общего у наших шуток и почты России?", "Не до всех доходит", STATUS_NEW, false);
    initialInsertRow(db, "Почему Гитлер не любил печь пироги?", "Ему вечно не хватало яиц", STATUS_NEW, false);
    initialInsertRow(db, "Чем похож первый секс и езда на велосипеде?", "И там и там отчим держит тебя за плечи", STATUS_NEW, false);
    initialInsertRow(db, "Почему глухонемая девушка мастурбирует одной рукой?", "Второй она стонет", STATUS_NEW, false);
    initialInsertRow(db, "Почему религиозным фанатикам моча в голову бьёт?", "Потому что бог вездессущий", STATUS_NEW, false);
    initialInsertRow(db, "Почему у Иисуса нет девушки?", "Зачем? У него и так есть две дырки на руках", STATUS_NEW, false);
    initialInsertRow(db, "Приходит Иисус к владельцу отеля, протягивает горсть гвоздей и спрашивает :", "\"А можно к вам на ночь прибиться?\"", STATUS_NEW, false);
    initialInsertRow(db, "Что брат, ебущий сестру, сказал, когда она спросила, как вошло?", "Зашёл как родной", STATUS_NEW, false);
    initialInsertRow(db, "Как называется собрание геев?", "Сход_очка", STATUS_NEW, false);
    initialInsertRow(db, "Почему Мексика никогда не побеждает на олимпийских играх?", "Потому что все мексиканцы, которые умеют хорошо бегать, прыгать и плавать уже давно в США", STATUS_NEW, false);
    initialInsertRow(db, "Что совершает еврейский гей", "Камин-аут", STATUS_NEW, false);
    initialInsertRow(db, "Почему голландский гей-клуб называется \"Корабль\"?", "Там можно встать за штурвал", STATUS_NEW, false);
    initialInsertRow(db, "Что общего у моей гениальной идеи и ребёнка пары геев?", "Они оба никогда не родятся.", STATUS_NEW, false);
    initialInsertRow(db, "Что общего между супермаркетом и психушкой?", "И там, и там есть овощной отдел.", STATUS_NEW, false);
    initialInsertRow(db, "Что общего у детей антипрививочников?", "Братская могила", STATUS_NEW, false);
    initialInsertRow(db, "Почему Кличко открывает йогурт в магазине", "На нем написано написано \"открыть здесь\"", STATUS_NEW, false);
    initialInsertRow(db, "Как называется призыв в диванные войска?", "Мебелизация", STATUS_NEW, false);
    initialInsertRow(db, "Чем любят играть дети каннибалов?", "Чужими лопатками", STATUS_NEW, false);
    initialInsertRow(db, "Почему женщинам в тюрьме проще чем мужчинам?", "Два слота под инвентарь", STATUS_NEW, false);
    initialInsertRow(db, "Я узнал что моя девушка беременна и заплакал", "Потому что понимал, как трудно расти ребёнку без отца", STATUS_NEW, false);
  }
  
  @Override
  public void onUpgrade(SQLiteDatabase db,
                        int oldVersion,
                        int newVersion) {
  
  }
  
  // PUBLIC METHODS
  
  // Update writable DB
  public synchronized static SQLiteDatabase updateDB(Context context) {
    if (db == null) {
      db = new JokeDB(context, DB_NAME, null, DB_VERSION);
    }
    
    if (data != null) {
      data.close();
    }
    data = db.getWritableDatabase();
  
    return data;
  }
  
  public synchronized static SQLiteDatabase updateDB(String dbName,
                                                     ContentValues content,
                                                     String where,
                                                     String[] args) {
    
    if (data != null) {
      data.update(dbName, content, where, args);
      data.close();
    }
    data = db.getWritableDatabase();
    
    return data;
  }
  
  // Get DB
  public static SQLiteDatabase db() {
    return data;
  }
  
  // Update and get cursor
  public static Cursor updateListJokesCursor(String cursorType) {
    if (cursor != null) cursor.close();
    
    switch (cursorType) {
      
      case CURSOR_TYPE_ALL:
        cursor = data.query(
          DB_NAME,
          new String[]{
            COL_ID,
            COL_CUTTED,
            COL_SET_UP,
            COL_PUNCHLINE,
            COL_STATUS,
            COL_IS_FAVORITE },
          null,
          null,
          null,
          null,
          null );
        
        break;
        
      case CURSOR_TYPE_UNWATCHED:
        cursor = data.query(
          JokeDB.DB_NAME,
          new String[]{
            JokeDB.COL_ID,
            JokeDB.COL_SET_UP,
            JokeDB.COL_CUTTED,
            JokeDB.COL_PUNCHLINE,
            JokeDB.COL_STATUS,
            JokeDB.COL_IS_FAVORITE,
          },
          JokeDB.COL_STATUS + " IN (?, ?) AND " + JokeDB.COL_IS_FAVORITE + " = 0 ",
          new String[]{
              String.valueOf(JokeDB.STATUS_NEW),
              String.valueOf(JokeDB.STATUS_SET_UP_WATCHED)
          },
          null,
          null,
          null );
        
        break;
        
      case CURSOR_TYPE_FAVORITE:
        cursor = data.query(
          JokeDB.DB_NAME,
          new String[]{
            JokeDB.COL_ID,
            JokeDB.COL_SET_UP,
            JokeDB.COL_CUTTED,
            JokeDB.COL_PUNCHLINE,
            JokeDB.COL_STATUS,
            JokeDB.COL_IS_FAVORITE,
          },
          JokeDB.COL_IS_FAVORITE + " = ?",
          new String[]{
            String.valueOf(1)
          },
          null,
          null,
          null );
        
        break;
        
      case CURSOR_TYPE_WATCHED:
        cursor = data.query(
          JokeDB.DB_NAME,
          new String[]{
            JokeDB.COL_ID,
            JokeDB.COL_SET_UP,
            JokeDB.COL_CUTTED,
            JokeDB.COL_PUNCHLINE,
            JokeDB.COL_STATUS,
            JokeDB.COL_IS_FAVORITE,
          },
          JokeDB.COL_STATUS + " = ? AND " + JokeDB.COL_IS_FAVORITE + " = 0",
          new String[]{
            String.valueOf(JokeDB.STATUS_PUNCHLINE_WATCHED)
          },
          null,
          null,
          null );
        
        break;
        
      default:
        cursor = updateListJokesCursor(JokeDB.CURSOR_TYPE_ALL);
        
        break;
    }
  
    return cursor;
  }
  
  // Get cursor
  public static Cursor cursor() {
    return cursor;
  }
  
  // ViewHolder position -> SQLite ID
  public static int posToID(int position) {
    return position + 1;
  }

  // SQLite ID -> ViewHolder position
  public static int idToPos(int position) {
    return position - 1;
  }
  
  // Close ALL
  public static void closeAll() {
    if (cursor != null) {cursor.close();}
    if (data != null) {data.close();}
    if (db != null) {db.close();}
  }
  
  // PRIVATE METHODS
  
  private static void initialInsertRow(SQLiteDatabase db,
                                       String setUp,
                                       String punchline,
                                       int status,
                                       boolean isFavorite) {
    ContentValues content = new ContentValues();
    content.put(COL_SET_UP, setUp);
    content.put(COL_CUTTED, getCuttedString(setUp));
    content.put(COL_PUNCHLINE, punchline);
    content.put(COL_STATUS, status);
    content.put(COL_IS_FAVORITE, booleanToInt(isFavorite));
    
    db.insert(DB_NAME, null, content);
  }
  
  // PRIVATE HELPERS METHODS
  
  private static int booleanToInt(boolean b) {
    return b ? 1 : 0;
  }
  
  private static String getCuttedString(String s) { return s.length() > cutter ? s.substring(0, cutter) + separator : s; }
  
}
