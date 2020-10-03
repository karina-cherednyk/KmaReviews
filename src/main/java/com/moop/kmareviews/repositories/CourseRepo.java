package com.moop.kmareviews.repositories;

import com.moop.kmareviews.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
