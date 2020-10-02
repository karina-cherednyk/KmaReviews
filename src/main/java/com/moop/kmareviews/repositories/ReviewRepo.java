package com.moop.kmareviews.repositories;

import com.moop.kmareviews.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReviewRepo extends JpaRepository<Review, Long>{}
