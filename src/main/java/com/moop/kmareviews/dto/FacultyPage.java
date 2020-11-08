package com.moop.kmareviews.dto;

import com.moop.kmareviews.entities.Faculty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FacultyPage {
    private List<Faculty> faculties;
    private int currentPage;
    private int totalPages;
}
