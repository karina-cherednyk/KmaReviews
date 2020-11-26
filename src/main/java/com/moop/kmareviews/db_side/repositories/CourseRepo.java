package com.moop.kmareviews.db_side.repositories;

import com.moop.kmareviews.db_side.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
