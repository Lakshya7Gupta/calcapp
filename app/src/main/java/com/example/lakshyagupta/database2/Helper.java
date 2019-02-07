package com.example.lakshyagupta.database2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {


    public static final String Dname = "Database.db";
    public static final int Version = 10;
    public static final String TName = "TableName";
    public static final String ID = "_ID";
    public static final String Name = "Name";
    public static final String Address = "Address";
    public static final String Password = "Password";


    SQLiteDatabase myDb;

    public Helper(Context context) {
        super(context, Dname, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryTable = "Create Table " + TName + "( " + ID + " INTEGER PRIMARY KEY, " + Name + " TEXT, " + Address + " TEXT, " + Password + " )";
        sqLiteDatabase.execSQL(queryTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     /*   sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TName);
        onCreate(sqLiteDatabase);*/
    }

    public boolean insertData(String id, String name, String Add, String Pass) {
        ContentValues content = new ContentValues();
        content.put(ID, id);
        content.put(Name, name);
        content.put(Address, Add);
        content.put(Password,Pass);
        long result = myDb.insert(TName, null, content);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAlldata()
    {
        return myDb.rawQuery("Select * From " + TName,null);

    }

    public void openDb() throws SQLException
    {
        myDb = this.getWritableDatabase();
    }
    public void closeDb()
    {
        if(myDb!=null && myDb.isOpen())
        {
            myDb.close();
        }
    }

}
