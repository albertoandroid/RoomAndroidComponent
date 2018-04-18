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

import java.util.ArrayList;
import java.util.List;

public class LanguagesActivity extends AppCompatActivity {

    private EditText etNombre;
    private Button btSalvar, btLeer, btActualizar, btBorrar;

    private Languages languages;
    private List<Languages> listLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        configView();
    }

    private void configView(){
        languages = new Languages();
        listLanguages = new ArrayList<>();

        etNombre = findViewById(R.id.languageActivityName);
        btSalvar = findViewById(R.id.languageActivityBtSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languages.setName(etNombre.getText().toString());
                AppDb.getAppDb(getApplicationContext()).languagesDAO().insert(languages);
            }
        });

        btLeer = findViewById(R.id.languageActivityBtLeerCursosPorProfesor);
        btLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listLanguages = AppDb.getAppDb(getApplicationContext()).languagesDAO().findAllLanguages();
                for(Languages languages: listLanguages){
                    Log.d("TAG", "id: " + languages.getId()+ " Nombre: " + languages.getName());
                }
            }
        });

        btActualizar = findViewById(R.id.languageActivityBtActualizarCursosPorId);
        btActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languages.setId(1);
                languages.setName("Java 8");
                AppDb.getAppDb(getApplicationContext()).languagesDAO().updateLanguageById(languages);
            }
        });

        btBorrar = findViewById(R.id.languageActivityBtBorrarCursosPorId);
        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languages.setId(1);
                AppDb.getAppDb(getApplicationContext()).languagesDAO().deleteLanguageById(languages);
            }
        });
    }
}
