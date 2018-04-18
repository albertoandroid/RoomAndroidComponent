package com.androiddesdecero.roomudemy.db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.androiddesdecero.roomudemy.constans.Constans;
import com.androiddesdecero.roomudemy.db.dao.ProfessorDAO;
import com.androiddesdecero.roomudemy.db.entity.Professor;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Database(entities = {Professor.class}, version = 1)
public abstract class AppDb extends RoomDatabase {

    private static AppDb INSTANCE;
    public abstract ProfessorDAO professorDAO();

    public static AppDb getAppDb(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDb.class, Constans.NAME_DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
