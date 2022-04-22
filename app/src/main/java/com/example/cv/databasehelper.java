package com.example.cv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databasehelper extends SQLiteOpenHelper {
    private static final String Database_Name="Testing";
    private static final int Database_Version=1;
    private static final String Table_Test="Test";
    private static final String KEY_ID="id";

    private static final String KEY_NAME="name";
    private static final String KEY_MAIL="mail";
    private static final String KEY_PHONE_NO="phone_no";
    private static final String KEY_DESCRIPTION="description";
    private static final String KEY_DEGREE="degree";
    private static final String KEY_SKILL="skill";
    private static final String KEY_EXPERIENCE="experience";






    public databasehelper(Context context) {
        super(context, Database_Name, null, Database_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create Table
        sqLiteDatabase.execSQL(" CREATE TABLE " + Table_Test +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_NAME + " TEXT NOT NULL," + KEY_MAIL + " TEXT ," +
                KEY_PHONE_NO + " TEXT ," +KEY_DESCRIPTION + " TEXT ," +KEY_DEGREE + " TEXT ," +KEY_SKILL + " TEXT, " + KEY_EXPERIENCE + " TEXT " +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_Test); // for delete data from tabe
        onCreate(sqLiteDatabase);
    }

    public boolean addContact(String name,String mail, String phone_no,String Description,String Degree,String Skill,String Experience) {
        SQLiteDatabase dp=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_MAIL,mail);
        values.put(KEY_PHONE_NO, phone_no);
        values.put(KEY_DESCRIPTION,Description);
        values.put(KEY_DEGREE,Degree);
        values.put(KEY_SKILL,Skill);
        values.put(KEY_EXPERIENCE,Experience);
        long result=dp.insert(Table_Test,null,values);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getallDATA()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+Table_Test,null);
        return res;
    }
}
