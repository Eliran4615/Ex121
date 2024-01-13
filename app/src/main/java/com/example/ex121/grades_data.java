package com.example.ex121;

import static com.example.ex121.Grades_table.GRADES;
import static com.example.ex121.Grades_table.QUARTER;
import static com.example.ex121.Grades_table.SUBJECT;
import static com.example.ex121.Grades_table.TYPE;
import static com.example.ex121.Student_table.Address;
import static com.example.ex121.Student_table.Full_name;
import static com.example.ex121.Student_table.Mom_name;
import static com.example.ex121.Student_table.Personal_phone;
import static com.example.ex121.Student_table.TABLE_Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class grades_data extends AppCompatActivity {
    EditText grade, subject, tt, quarter;
    SQLiteDatabase db;
    HelperDB hlp;
    private ArrayList<String> names;
    Spinner name_selection;
    String[] columns;
    Cursor crsr;
    ArrayAdapter<String> adp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_input);
        grade = findViewById(R.id.grade);
        subject = findViewById(R.id.subject);
        tt = findViewById(R.id.tt);
        name_selection = (Spinner) findViewById(R.id.name_selection);
        quarter = findViewById(R.id.quarter);
        hlp = new HelperDB(this);


    }


    public void save_g(View view) {
        ContentValues cv = new ContentValues();

        cv.put(GRADES, grade.getText().toString());
        cv.put(SUBJECT, subject.getText().toString());
        cv.put(TYPE, tt.getText().toString());
        cv.put(QUARTER, quarter.getText().toString());

        db = hlp.getWritableDatabase();

        db.insert(Grades_table.TABLE_Grades, null, cv);

        db.close();

    }

    private void initiall() {
        hlp = new HelperDB(this);
        names = new ArrayList<>();

        db = hlp.getWritableDatabase();
        columns = new String[]{Student_table.Full_name};
        names.add("Choose Student");

        crsr = db.query(TABLE_Student, columns, null, null, null, null, null);

        crsr.moveToFirst();
        while (!crsr.isAfterLast()) {
            names.add(crsr.getString(Math.abs(crsr.getColumnIndex(Student_table.Full_name))));
            crsr.moveToNext();
        }
        crsr.close();
        db.close();
        adp = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, names);
        name_selection.setAdapter(adp);
        name_selection.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    /**
     * reacts to item selection.
     * <p>
     *
     * @param    item Description    refers to the selected menu item.
     * @return    Description            returns true.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuCredits){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        else if (id ==R.id.menuGrades) {
            Intent si = new Intent(this, grades_data.class);
            startActivity(si);
        }

        else if (id ==R.id.menuStudent) {
            Intent si = new Intent(this, Student_data.class);
            startActivity(si);
        }
        else if (id ==R.id.menuDelete) {
            Intent si = new Intent(this, Grades_delete_option.class);
            startActivity(si);
        }
        return true;
    }

}