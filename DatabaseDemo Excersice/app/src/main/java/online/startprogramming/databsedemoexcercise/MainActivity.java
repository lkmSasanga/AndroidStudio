package online.startprogramming.databsedemoexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
//            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, year INT(4))");
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS NewUsers (name VARCHAR, age INT(4), id INTEGER PRIMARY KEY)");


//            sqLiteDatabase.execSQL("INSERT INTO NewUsers (name, age) VALUES ('Nick', 18)");
//            sqLiteDatabase.execSQL("INSERT INTO NewUsers (name, age) VALUES ('Nick', 23)");
//            sqLiteDatabase.execSQL("INSERT INTO NewUsers (name, age) VALUES ('Dob', 23)");
//
//            sqLiteDatabase.execSQL("INSERT INTO NewUsers (name, age) VALUES ('Bob', 45)");

//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name = 'Nick' AND age = 23",null);

            //  all the users names starting in N
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'N%'",null);

            //  users who has o in name
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%o%' LIMIT 1",null);

            //  delete
//            sqLiteDatabase.execSQL("DELETE FROM NewUsers WHERE name = 'Dob'");
            sqLiteDatabase.execSQL("DELETE FROM NewUsers WHERE id = 1");


            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM NewUsers",null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            while (c != null) {
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UserResults - id", Integer.toString(c.getInt(idIndex)));


                //to go next row in db
                c.moveToNext();

            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}