package com.androiddesdecero.roomudemy.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

import com.androiddesdecero.roomudemy.constans.Constans;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Entity(tableName = Constans.NAME_TABLE_COURSE,
        foreignKeys = @ForeignKey(entity = Professor.class,
            parentColumns = "id",
            childColumns = "professorId",
            onDelete = CASCADE))
public class Course {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "duration")
    public String duration;
    @ColumnInfo(name = "professorId")
    public int professorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
