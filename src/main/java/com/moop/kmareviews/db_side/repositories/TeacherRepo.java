package com.moop.kmareviews.db_side.repositories;

import com.moop.kmareviews.db_side.entities.Faculty;
import com.moop.kmareviews.db_side.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    List<Teacher> findByFaculty(Faculty faculty);

    @Query(value = "SELECT * FROM TEACHER WHERE FACULTY_ID = :faculty", nativeQuery = true)
    Page<Teacher> findByFacultyPageable(@Param("faculty") long facultyId, Pageable pageable);
}


