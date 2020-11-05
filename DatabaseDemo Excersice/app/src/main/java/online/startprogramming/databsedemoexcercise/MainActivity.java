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
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");

            sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('MIlenieum', 2000)");
            sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Nick started teaching', 2014)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM events",null);
            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("year");
            c.moveToFirst();

            while (c != null) {
                Log.i("Results - name", c.getString(nameIndex));
                Log.i("Results - year", Integer.toString(c.getInt(yearIndex)));

                //to go next row in db
                c.moveToNext();

            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}