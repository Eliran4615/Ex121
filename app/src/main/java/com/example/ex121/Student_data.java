package com.example.ex121;

import static com.example.ex121.Student_table.Address;
import static com.example.ex121.Student_table.Dad_name;
import static com.example.ex121.Student_table.Dad_phone;
import static com.example.ex121.Student_table.Full_name;
import static com.example.ex121.Student_table.Mom_name;
import static com.example.ex121.Student_table.Mom_phone;
import static com.example.ex121.Student_table.Personal_phone;

import static java.lang.System.in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;


public class Student_data extends AppCompatActivity implements View.OnCreateContextMenuListener  {
    AlertDialog.Builder adb;
    ContentValues cv = new ContentValues();
    EditText dn,dp,mn,pp,mp,address,save,fn;
    SQLiteDatabase db;
    HelperDB hlp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);
        address = findViewById(R.id.address);
        dn =findViewById(R.id.dn);
        dp =findViewById(R.id.dp);
        mn =findViewById(R.id.mn);
        pp =findViewById(R.id.pp);
        mp =findViewById(R.id.mp);
        fn =findViewById((R.id.fn));

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();







    }

    /**
     * creates the context menu.
     * <p>
     *
     * @param    menu Description    refers to the current context menu.
     * @return    Description            returns a super action of this function.
     */
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
        Intent st = new Intent(this, Student_data.class);
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



    public void save(View view) {
        cv.put(Full_name, fn.getText().toString());
        cv.put(Address, address.getText().toString() );
        cv.put(Personal_phone, pp.getText().toString());
        cv.put(Mom_name, mn.getText().toString());
        cv.put(Mom_phone, mp.getText().toString() );
        cv.put(Dad_name, dn.getText().toString());
        cv.put(Dad_phone, dp.getText().toString());
        db = hlp.getWritableDatabase();
        db.insert(Student_table.TABLE_Student, null, cv);


        db.close();
        Toast.makeText(this,"record save",Toast.LENGTH_LONG).show();



    }

}