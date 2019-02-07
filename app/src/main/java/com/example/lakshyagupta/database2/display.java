package com.example.lakshyagupta.database2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class display extends AppCompatActivity {

    Helper dispdb;
    TextView textView;
    Button btndisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        dispdb= new Helper(this);
        btndisp= (Button)findViewById(R.id.button3);
        textView = (TextView)findViewById(R.id.textView);
        displaydata();


    }

    public void displaydata() {
        btndisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                StringBuffer finalData = new StringBuffer();
                Cursor cursor = dispdb.getAlldata();
                //  crs = dbHelper.getDataBasedOnQuery("SELECT * FROM " + MyDBHelper.TName
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    finalData.append(cursor.getInt(cursor.getColumnIndex(dispdb.ID)));
                    finalData.append("    ");
                    finalData.append(cursor.getString(cursor.getColumnIndex(dispdb.Name)));
                    finalData.append("    ");
                    finalData.append(cursor.getString(cursor.getColumnIndex(dispdb.Address)));
                    finalData.append("    ");
                    finalData.append(cursor.getString(cursor.getColumnIndex(dispdb.Password)));
                    finalData.append("\n");
                }
                textView.setText(finalData);
                System.getProperty("Line Separator");

            }
        });

    }

    protected void onStart()
    {

        super.onStart();
        dispdb.openDb();
    }


    protected void onStop()
    {
        super.onStop();
        dispdb.closeDb();
    }

}

