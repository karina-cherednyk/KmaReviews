package com.moop.kmareviews.exceptions;

import java.util.List;

public class NotUniqueTeacherNameException extends Throwable {
    List<String> teachers;

    public NotUniqueTeacherNameException(List<String> t) {
        teachers = t;
    }
    public List<String> getTeachers() {
        return teachers;
    }
}


