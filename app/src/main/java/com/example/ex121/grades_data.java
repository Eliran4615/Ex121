package com.example.ex121;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class grades_data extends AppCompatActivity {
    EditText grade,subject,tt,quarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_input);
        grade = findViewById(R.id.grade);
    }


}