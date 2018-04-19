package com.androiddesdecero.roomudemy.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.androiddesdecero.roomudemy.db.entity.Languages;
import com.androiddesdecero.roomudemy.db.entity.Professor;
import com.androiddesdecero.roomudemy.db.entity.ProfessorLanguage;

import java.util.List;

/**
 * Created by albertopalomarrobledo on 19/4/18.
 */

@Dao
public interface ProfessorLanguageDAO {

    @Insert
    void insert(ProfessorLanguage professorLanguage);

    @Query("SELECT * FROM professor INNER JOIN professorlanguages ON professor.id=professorlanguages.profesorId WHERE professorlanguages.languajeId=:lenguajeId")
    List<Professor> getProfessorForRepository(int lenguajeId);

    @Query("SELECT * FROM languages INNER JOIN professorlanguages ON languages.id=professorlanguages.languajeId WHERE professorlanguages.profesorId=:profesorId")
    List<Languages> getLanguagesForRepository(int profesorId);
}
