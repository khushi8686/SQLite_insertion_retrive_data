package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class testing extends AppCompatActivity {
    ListView listView;
    databasehelper db;
    ArrayList<contantmodel> arrayList;
    myadapter myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_testing);
                listView=findViewById(R.id.list_item);
                db=new databasehelper(this);
                loadDatainlistview();
                arrayList=new ArrayList<>();
    }

    private void loadDatainlistview() {
        arrayList=db.getdata();
        myadapters=new myadapter(this,arrayList);
        listView.setAdapter(myadapters);
        myadapters.notifyDataSetChanged();
    }
}