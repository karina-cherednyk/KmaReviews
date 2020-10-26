package com.moop.kmareviews.repositories;

import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long>{
    List<Review> findReviewByTeacher(Teacher teacher);
}
