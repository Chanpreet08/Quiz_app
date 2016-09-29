package quiz.com.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.QuoteSpan;

import java.util.ArrayList;
import java.util.List;

public class dbhelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="quizapp";

    private static final String TABLE_NAME="questions";

    private static final String KEY_ID="id";

    private static final String KEY_QUESTION="question";

    private static final String KEY_OPTA="opta";

    private static final String KEY_OPTB="optb";

    private static final String KEY_OPTC="optc";

    private static final String ANSWER="answer";

    private SQLiteDatabase db;

    public dbhelper(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbname) {
        db= dbname;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESTION
                + " TEXT, " + ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        dbname.execSQL(sql);

        Questions q1 = new Questions("How long is the Great Wall of China?","4000 Miles","5000 Miles","6000 Miles","4000 Miles");
        add(q1);
        Questions q2 = new Questions("What colour to do you get when you mix red and white?","Blue","Green","Pink","Pink");
        add(q2);
        Questions q3 = new Questions("What is the name of the Indian holy river?","Yamuna","Chambal","Ganges","Ganges");
        add(q3);
        Questions q4 = new Questions("What is the largest number of five digits?","9999","99999","999999","99999");
        add(q4);
        Questions q5 = new Questions("What kind of animal is the largest living creature on Earth?","Whale","Elephant","Lion","Whale");
        add(q5);
        Questions q6 = new Questions("What's the currency of India?","Dollar","Rupee","Dinar","Rupee");
        add(q6);

    }

    private void add(Questions q)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_QUESTION,q.getQuestions());
        cv.put(ANSWER,q.getAnswer());
        cv.put(KEY_OPTA, q.getOpta());
        cv.put(KEY_OPTB,q.getOptb());
        cv.put(KEY_OPTC,q.getOptc());
        db.insert(TABLE_NAME,null,cv);
    }

    public List<Questions> getquestions()
    {
        List<Questions> qlist = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String selected= "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = db.rawQuery(selected,null);

        if(cursor.moveToFirst()) {
            do {
                  Questions q = new Questions();
                   q.setId(cursor.getInt(0));
                   q.setQuestions(cursor.getString(1));
                  q.setAnswer(cursor.getString(2));
                   q.setOpta(cursor.getString(3));
                   q.setOptb(cursor.getString(4));
                   q.setOptc(cursor.getString(5));
                qlist.add(q);

            }
            while(cursor.moveToNext());
        }
        return qlist;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
