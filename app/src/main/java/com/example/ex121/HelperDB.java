package com.example.ex121;

import static com.example.ex121.Grades_table.GRADES;
import static com.example.ex121.Grades_table.KEY_ID;
import static com.example.ex121.Grades_table.QUARTER;
import static com.example.ex121.Grades_table.SUBJECT;
import static com.example.ex121.Grades_table.TABLE_Grades;
import static com.example.ex121.Grades_table.TYPE;
import static com.example.ex121.Student_table.Address;
import static com.example.ex121.Student_table.Dad_name;
import static com.example.ex121.Student_table.Full_name;
import static com.example.ex121.Student_table.Mom_name;
import static com.example.ex121.Student_table.Mom_phone;
import static com.example.ex121.Student_table.Personal_phone;
import static com.example.ex121.Student_table.TABLE_Student;
import static com.example.ex121.Student_table.Dad_phone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class HelperDB extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "dbexam.db";
        private static final int DATABASE_VERSION = 1;
        String strCreate, strDelete;

        public HelperDB(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            strCreate="CREATE TABLE "+TABLE_Grades;
            strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
            strCreate+=" "+GRADES+" INTEGER,";
            strCreate+=" "+SUBJECT+" TEXT,";
            strCreate+=" "+TYPE+" TEXT,";
            strCreate+=" "+QUARTER+" TEXT";
            strCreate+=");";
            db.execSQL(strCreate);

            strCreate="CREATE TABLE "+TABLE_Student;
            strCreate+=" ("+Student_table.KEY_ID+" INTEGER PRIMARY KEY,";
            strCreate+=" "+Full_name+" TEXT,";
            strCreate+=" "+Address+" TEXT,";
            strCreate+=" "+Personal_phone+" TEXT,";
            strCreate+=" "+Mom_name+" TEXT,";
            strCreate+=" "+Mom_phone+" INTEGER,";
            strCreate+=" "+Dad_name+" TEXT,";
            strCreate+=" "+Dad_phone+" INTEGER";


            strCreate+=");";
            db.execSQL(strCreate);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

            strDelete="DROP TABLE IF EXISTS "+TABLE_Student;
            db.execSQL(strDelete);
            strDelete="DROP TABLE IF EXISTS "+TABLE_Grades;
            db.execSQL(strDelete);

            onCreate(db);
        }
    }


