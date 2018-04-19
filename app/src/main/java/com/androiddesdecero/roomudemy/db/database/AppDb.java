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
import com.androiddesdecero.roomudemy.db.dao.LanguagesDAO;
import com.androiddesdecero.roomudemy.db.dao.ProfessorDAO;
import com.androiddesdecero.roomudemy.db.dao.ProfessorLanguageDAO;
import com.androiddesdecero.roomudemy.db.entity.Course;
import com.androiddesdecero.roomudemy.db.entity.Languages;
import com.androiddesdecero.roomudemy.db.entity.Professor;
import com.androiddesdecero.roomudemy.db.entity.ProfessorLanguage;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Database(entities = {Professor.class, Course.class, Languages.class, ProfessorLanguage.class}, version = 4)
public abstract class AppDb extends RoomDatabase {

    private static AppDb INSTANCE;
    public abstract ProfessorDAO professorDAO();
    public abstract CourseDAO courseDAO();
    public abstract LanguagesDAO languagesDAO();
    public abstract ProfessorLanguageDAO professorLanguageDAO();

    public static AppDb getAppDb(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDb.class, Constans.NAME_DATABASE)
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .addMigrations(MIGRATION_2_3)
                    .addMigrations(MIGRATION_3_4)
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

    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE languages (id INTEGER PRIMARY KEY NOT NULL, name TEXT)");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE professorlanguages (profesorId INTEGER NOT NULL, languajeId INTEGER NOT NULL, PRIMARY KEY (profesorId, languajeId) foreign key (profesorId) references professor(id),foreign key (languajeId) references languages(id))");
        }
    };
}
