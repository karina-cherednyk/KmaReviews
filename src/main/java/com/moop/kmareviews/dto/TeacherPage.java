package com.moop.kmareviews.dto;

import com.moop.kmareviews.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeacherPage {
    private List<Teacher> teachers;
    private int currentPage;
    private int totalPages;
}
