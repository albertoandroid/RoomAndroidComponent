package com.androiddesdecero.roomudemy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androiddesdecero.roomudemy.R;
import com.androiddesdecero.roomudemy.db.database.AppDb;
import com.androiddesdecero.roomudemy.db.entity.Languages;
import com.androiddesdecero.roomudemy.db.entity.Professor;
import com.androiddesdecero.roomudemy.db.entity.ProfessorLanguage;

import java.util.ArrayList;
import java.util.List;

public class ProfessorLanguagesActivity extends AppCompatActivity {

    private EditText etIdProfesor, etIdLenguaje;
    private Button btSalvar, btGetProfesor, btGetLenguaje;

    private ProfessorLanguage professorLanguage;
    private List<Professor> professors;
    private List<Languages> languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_languages);
        configView();
    }

    private void configView(){
        professors = new ArrayList<>();
        languages = new ArrayList<>();
        professorLanguage = new ProfessorLanguage();


        etIdProfesor = findViewById(R.id.professorLanguageActivityEtProfesorId);
        etIdLenguaje = findViewById(R.id.professorLanguageActivityEtLenguajeId);

        btSalvar = findViewById(R.id.professorLanguageActivityBtSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                professorLanguage.setLanguajeId(Integer.parseInt(etIdLenguaje.getText().toString()));
                professorLanguage.setProfesorId(Integer.parseInt(etIdProfesor.getText().toString()));

                AppDb.getAppDb(getApplicationContext()).professorLanguageDAO().insert(professorLanguage);
            }
        });

        btGetProfesor = findViewById(R.id.professorLanguageActivityBtLeerProfesores);
        btGetProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                professors = AppDb.getAppDb(getApplicationContext()).professorLanguageDAO().getProfessorForRepository(2);
                for(Professor professor: professors){
                    Log.d("TAG", "Nombre Profesor: " + professor.getName() + "\n");
                }
            }
        });

        btGetLenguaje = findViewById(R.id.professorLanguageActivityBtLeerLenguajes);
        btGetLenguaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languages = AppDb.getAppDb(getApplicationContext()).professorLanguageDAO().getLanguagesForRepository(5);
                for (Languages languages: languages){
                    Log.d("TAG", "Nombre Lenguaje Programacion: " + languages.getName());
                }
            }
        });
    }
}
