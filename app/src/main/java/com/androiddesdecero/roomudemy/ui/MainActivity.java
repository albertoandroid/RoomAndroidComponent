package com.androiddesdecero.roomudemy.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddesdecero.roomudemy.R;
import com.androiddesdecero.roomudemy.db.entity.Professor;

public class MainActivity extends AppCompatActivity {

    private Button btProfesor, btCurso, btLenguajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }
    private void configView(){
        btProfesor = findViewById(R.id.mainAcitivityBtProfessor);
        btProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfessorActivity.class));
            }
        });
        btCurso = findViewById(R.id.mainAcitivityBtCurso);
        btCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CourseActivity.class));
            }
        });

        btLenguajes = findViewById(R.id.mainAcitivityBtLenguajes);
        btLenguajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LanguagesActivity.class));
            }
        });
    }
}
