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
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, year INT(4))");

//            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick', 18)");
            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick', 23)");

//            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Bob', 45)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name = 'Nick' AND age = 23",null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            c.moveToFirst();

            while (c != null) {
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));

                //to go next row in db
                c.moveToNext();

            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}