package com.example.lab505b.dp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper2 extends SQLiteOpenHelper {


    public static final String DATABASE_NAME="university.db";
    public static final int DATABASE_VERSION=1;
    public static final String STUDENTS_TABLE_NAME="students";
    public static final String STUDENTS_COLUMN_ID="sid";
    public static final String STUDENTS_COLUMN_NAME="name";


    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ STUDENTS_TABLE_NAME+
                "("+ STUDENTS_COLUMN_ID+" numeric(9) primary key, "
                +STUDENTS_COLUMN_NAME+" varchar(50) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //the below code is for testing only purposes, you should always preserve the old user data
        // before removing any tables.
        db.execSQL("drop Table if exists " + STUDENTS_TABLE_NAME);
        onCreate(db);
    }

    public void addStudent(Student s){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(STUDENTS_COLUMN_ID,s.getid());
        v.put(STUDENTS_COLUMN_NAME,s.getNAme());
        db.insertWithOnConflict(STUDENTS_TABLE_NAME,null,v,SQLiteDatabase.CONFLICT_ABORT);
        db.close();
    }
}
