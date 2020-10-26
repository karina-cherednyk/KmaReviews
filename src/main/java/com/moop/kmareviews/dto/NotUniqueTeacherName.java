package com.moop.kmareviews.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NotUniqueTeacherName {
    List<String> teachers;
    String message;

}
