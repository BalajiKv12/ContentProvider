package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView resultView;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent u = getIntent();
         resultView= findViewById(R.id.res);

        // creating a cursor object of the
        // content URI
        Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI,
                null, null, null, null);

        // iteration of the cursor
        // to print whole table
        if(cursor.moveToFirst()) {
            StringBuilder strBuild=new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n").
                        append(cursor.getString(cursor.getColumnIndex(MyContentProvider.name))).
                        append("-").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.id))).
                        append("-").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.desig))).
                        append("-").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.salary)));
                cursor.moveToNext();
            }
            resultView.setText(strBuild);
        }
        else {
            resultView.setText("No Records Found");
        }
    }
}
