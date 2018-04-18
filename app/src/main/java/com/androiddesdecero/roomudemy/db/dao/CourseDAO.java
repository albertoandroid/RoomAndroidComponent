package com.androiddesdecero.roomudemy.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.androiddesdecero.roomudemy.db.entity.Course;

import java.util.List;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

@Dao
public interface CourseDAO {

    @Insert
    void insert(Course course);

    @Query("SELECT * FROM curso WHERE professorId=:professorId")
    List<Course> findCoursesForProfessor(int professorId);

    @Update
    void updateCourseByID(Course course);

    @Delete
    void deleteCourseByID(Course course);

}
