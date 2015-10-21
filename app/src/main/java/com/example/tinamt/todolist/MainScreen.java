package com.example.tinamt.todolist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {
    CategoriesDBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mDbHelper = new CategoriesDBHelper(getApplicationContext());

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                CategoriesContract.CatgoryEntry._ID,
                CategoriesContract.CatgoryEntry.COLUMN_NAME_CATEGORY_NAME,

        };

        Cursor cursor = db.query(
                CategoriesContract.CatgoryEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(CategoriesContract.CatgoryEntry._ID)
            );
            String category = cursor.getString(
                    cursor.getColumnIndexOrThrow(CategoriesContract.CatgoryEntry.COLUMN_NAME_CATEGORY_NAME)
            );
            TextView tv = new TextView(this);
            tv.setText(Long.toString(itemId) + ". " + category);

            LinearLayout ll = (LinearLayout)findViewById(R.id.mainLayout);
            ll.addView(tv);
            
            cursor.moveToNext();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addNewCategory(View view) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        long id = 123;
        String category = "xxx";
        ContentValues values = new ContentValues();
        values.put(CategoriesContract.CatgoryEntry.COLUMN_NAME_ENTRY_ID, id);
        values.put(CategoriesContract.CatgoryEntry.COLUMN_NAME_CATEGORY_NAME, category);

        long newRowId;
        newRowId = db.insert(
                CategoriesContract.CatgoryEntry.TABLE_NAME,
                CategoriesContract.CatgoryEntry.COLUMN_NAME_CATEGORY_NAME,
                values);
    }
}
