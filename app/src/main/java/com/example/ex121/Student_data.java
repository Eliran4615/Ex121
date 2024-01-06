package com.example.ex121;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;




public class Student_data extends AppCompatActivity {
    AlertDialog.Builder adb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);
        findViewById(R.id.address);
        findViewById(R.id.dn);
        findViewById(R.id.dp);
        findViewById(R.id.mn);
        findViewById(R.id.pp);
        findViewById(R.id.mp);
        findViewById(R.id.save);
        SQLiteDatabase db;
        HelperDB hlp;
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
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
        String st = item.getTitle().toString();
        if(st.equals("credit")) {
            Intent si = new Intent(this, Credits.class);
            startActivity(si);

        } else if (st.equals("grades")) {
        Intent si = new Intent(this, grades_input.class);
        startActivity(si);
            startActivity(si);
            adb = new AlertDialog.Builder(this);
            adb.setTitle("do you want to save?");
            adb.setMessage("do you want to save?");
            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main,menu);


        return super.onCreateOptionsMenu(menu);
    }





}