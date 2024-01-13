package com.example.ex121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Grades_delete_option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_delete_option);
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

}