package com.example.ex121;

import static com.example.ex121.Student_table.Address;
import static com.example.ex121.Student_table.Dad_name;
import static com.example.ex121.Student_table.Dad_phone;
import static com.example.ex121.Student_table.Full_name;
import static com.example.ex121.Student_table.Mom_name;
import static com.example.ex121.Student_table.Mom_phone;
import static com.example.ex121.Student_table.Personal_phone;

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

import java.util.Objects;


public class Student_data extends AppCompatActivity {
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("view Options");
        menu.add("personal");
        menu.add("grades");
        menu.add("delete");
        menu.add("filtering/sorting");
        menu.add("credits");

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        /**
         * function will check if the user clicked the credit button and if he did it will get him to the credits screen
         * param item: the item clicked
         */
        String st = Objects.requireNonNull(item.getTitle()).toString();
        if(st.equals("credit")) {
            Intent si = new Intent(this, Credits.class);
            startActivity(si);

        } else if (st.equals("grades")) {
            Intent si = new Intent(this, grades_data.class);
            startActivity(si);
        }
        else if (st.equals("student")) {
            Intent si = new Intent(this, Student_data.class);
            startActivity(si);
        }
     else if (st.equals("grades_d")) {
        Intent si = new Intent(this, Gareds_delete_option.class);
        startActivity(si);
    }

        return super.onOptionsItemSelected(item);
    }




    public void save(View view) {
        cv.put(Full_name, fn.getText().toString());
        cv.put(Address, address.getText().toString() );
        cv.put(Personal_phone, pp.getText().toString());
        cv.put(Mom_name, mn.getText().toString());
        cv.put(Mom_phone, mp.getText().toString() );
        cv.put(Dad_name, dn.getText().toString());
        cv.put(Dad_phone, dp.getText().toString());
        db.insert(Student_table.TABLE_Student, null, cv);

        db.close();



    }

}