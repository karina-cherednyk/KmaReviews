package com.moop.kmareviews.db_side.repositories;

import com.moop.kmareviews.db_side.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {}
