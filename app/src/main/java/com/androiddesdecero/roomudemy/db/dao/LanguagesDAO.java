package com.androiddesdecero.roomudemy.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.androiddesdecero.roomudemy.db.entity.Languages;

import java.util.List;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Dao
public interface LanguagesDAO {

    @Insert
    void insert(Languages languages);

    @Query("SELECT * FROM languages")
    List<Languages> findAllLanguages();

    @Update
    void updateLanguageById(Languages languages);

    @Delete
    void deleteLanguageById(Languages languages);
}
