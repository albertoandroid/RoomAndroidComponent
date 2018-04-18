package com.androiddesdecero.roomudemy.ui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androiddesdecero.roomudemy.R;
import com.androiddesdecero.roomudemy.db.database.AppDb;
import com.androiddesdecero.roomudemy.db.entity.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorActivity extends AppCompatActivity {

    private EditText etNombre, etEmail;
    private Button btSalvar, btLeerTodo, btLeerPorNombre, btLeerPorId, btActualizarPorId, btBorrarPorId, btBorrarAll;

    private Professor professor;
    private List<Professor> listProfessors;
    private EscribirBaseDatosTask escribirBaseDatosTask;
    private LeerBaseDatosTask leerBaseDatosTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        configView();
    }

    private void configView(){
        professor = new Professor();
        listProfessors = new ArrayList<>();
        etNombre = findViewById(R.id.professorActivityEtNombre);
        etEmail = findViewById(R.id.professorActivityEtEmail);
        btSalvar = findViewById(R.id.professorActivityBtSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                professor.setName(etNombre.getText().toString());
                professor.setEmail(etEmail.getText().toString());
                escribirBaseDatosTask = new EscribirBaseDatosTask();
                escribirBaseDatosTask.execute(professor);
            }
        });


        btLeerTodo = findViewById(R.id.professorActivityBtLeer);
        btLeerTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leerBaseDatosTask = new LeerBaseDatosTask();
                leerBaseDatosTask.execute();
            }
        });

        btLeerPorNombre = findViewById(R.id.professorActivityBtFindByName);
        btLeerPorNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                professor = AppDb.getAppDb(getApplicationContext()).professorDAO().findProfessorByName(etNombre.getText().toString());
                showProfessorUnit(professor);
            }
        });

        btLeerPorId = findViewById(R.id.professorActivityBtFindById);
        btLeerPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                professor = AppDb.getAppDb(getApplicationContext()).professorDAO().findProfessorById(1);
                showProfessorUnit(professor);
            }
        });
        btActualizarPorId = findViewById(R.id.professorActivityBtUpdateById);
        btActualizarPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Professor professor = new Professor();
                professor.setId(1);
                professor.setName("Manuel");
                professor.setEmail("manuel@manuel.com");
                AppDb.getAppDb(getApplicationContext()).professorDAO().updateProfessorById(professor);
            }
        });

        btBorrarPorId = findViewById(R.id.professorActivityBtDeleteById);
        btBorrarPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Professor professor = new Professor();
                professor.setId(2);
                AppDb.getAppDb(getApplicationContext()).professorDAO().deleteProfessorById(professor);
            }
        });

        btBorrarAll = findViewById(R.id.professorActivityBtDelete);
        btBorrarAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDb.getAppDb(getApplicationContext()).professorDAO().deleteAllProfessor();
            }
        });
    }

    private class EscribirBaseDatosTask extends AsyncTask<Professor, Void, Void>{

        @Override
        protected Void doInBackground(Professor... professors) {
            AppDb.getAppDb(getApplicationContext()).professorDAO().insertProfessor(professors[0]);
            return null;
        }
    }

    private class LeerBaseDatosTask extends AsyncTask<Void, Void, List<Professor>>{

        @Override
        protected List<Professor> doInBackground(Void... voids) {
            listProfessors = AppDb.getAppDb(getApplicationContext()).professorDAO().findAllProfessor();
            return listProfessors;
        }

        @Override
        protected void onPostExecute(List<Professor> professors){
            showProfessor(professors);
        }
    }

    private void showProfessor(List<Professor> professors){
        for(Professor professor: professors){
            Log.d("TAG", "ID: " + professor.getId() + " Nombre: " + professor.getName() + " Email: " + professor.getEmail() +  "\n");
        }
    }

    private void showProfessorUnit(Professor professor){
        Log.d("TAG", "Nombre: " + professor.getName() + " Email: " + professor.getEmail() +  "\n");
    }
}
