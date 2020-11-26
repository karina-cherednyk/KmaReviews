package com.moop.kmareviews.server_side.dto;

import com.moop.kmareviews.db_side.entities.Faculty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FacultyPageDTO {
    private List<Faculty> faculties;
    private int currentPage;
    private int totalPages;
}
