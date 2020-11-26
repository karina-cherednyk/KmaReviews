package com.moop.kmareviews.server_side.dto;

import com.moop.kmareviews.db_side.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeacherPageDTO {
    private List<Teacher> teachers;
    private int currentPage;
    private int totalPages;
}
