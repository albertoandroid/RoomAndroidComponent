package com.androiddesdecero.roomudemy.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.androiddesdecero.roomudemy.constans.Constans;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Entity(tableName = Constans.NAME_TABLE_LANGUAGES)
public class Languages {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    private String name;

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
}
