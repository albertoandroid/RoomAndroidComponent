package com.androiddesdecero.roomudemy.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import com.androiddesdecero.roomudemy.constans.Constans;

/**
 * Created by albertopalomarrobledo on 19/4/18.
 */

@Entity(tableName = Constans.NAME_TABLE_PROFESSOR_LANGUAGES,
        primaryKeys = {"profesorId", "languajeId"},
        foreignKeys = {
                @ForeignKey(entity = Professor.class,
                    parentColumns = "id",
                    childColumns = "profesorId"),
                @ForeignKey(entity = Languages.class,
                    parentColumns = "id",
                    childColumns = "languajeId")
        })
public class ProfessorLanguage {

    @ColumnInfo(name = "profesorId")
    public int profesorId;

    @ColumnInfo(name = "languajeId")
    public int languajeId;

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getLanguajeId() {
        return languajeId;
    }

    public void setLanguajeId(int languajeId) {
        this.languajeId = languajeId;
    }
}
