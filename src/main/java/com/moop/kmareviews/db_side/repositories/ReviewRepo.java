package com.moop.kmareviews.db_side.repositories;

import com.moop.kmareviews.db_side.entities.Review;
import com.moop.kmareviews.db_side.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long>{
    List<Review> findByTeacher(Teacher teacher);

    @Query(value = "SELECT * FROM REVIEW WHERE TEACHER_ID = :teacherId", nativeQuery = true)
    Page<Review> findByTeacher(@Param("teacherId") long facultyId, Pageable pageable);
}
