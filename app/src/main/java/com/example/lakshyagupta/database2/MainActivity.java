package com.example.lakshyagupta.database2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Helper formdb;
    EditText ed1, ed2, ed3, ed4;
    Button btnadd,btnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formdb = new Helper(this);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        btnadd = (Button) findViewById(R.id.button2);
        btnview = (Button) findViewById(R.id.button);
        addata();
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),display.class);
                startActivity(intent);
            }
        });

    }


    public void addata() {

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = formdb.insertData(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString());
                if (result == true) {
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error Occured ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    protected void onStart()
    {

        super.onStart();
        formdb.openDb();
    }


    protected void onStop()
    {
        super.onStop();
        formdb.closeDb();
    }

}