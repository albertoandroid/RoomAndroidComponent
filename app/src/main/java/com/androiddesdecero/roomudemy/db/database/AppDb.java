package com.androiddesdecero.roomudemy.db.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.androiddesdecero.roomudemy.constans.Constans;
import com.androiddesdecero.roomudemy.db.dao.CourseDAO;
import com.androiddesdecero.roomudemy.db.dao.ProfessorDAO;
import com.androiddesdecero.roomudemy.db.entity.Course;
import com.androiddesdecero.roomudemy.db.entity.Professor;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Database(entities = {Professor.class, Course.class}, version = 2)
public abstract class AppDb extends RoomDatabase {

    private static AppDb INSTANCE;
    public abstract ProfessorDAO professorDAO();
    public abstract CourseDAO courseDAO();

    public static AppDb getAppDb(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDb.class, Constans.NAME_DATABASE)
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE curso (id INTEGER PRIMARY KEY NOT NULL, name TEXT, duration TEXT, professorId INTEGER NOT NULL, foreign key (professorID) references professor(id) ON DELETE CASCADE)");
        }
    };
}
