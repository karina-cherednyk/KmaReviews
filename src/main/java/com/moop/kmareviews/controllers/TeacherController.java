package com.moop.kmareviews.controllers;
import com.moop.kmareviews.dto.NotUniqueTeacherName;
import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.exceptions.NotUniqueTeacherNameException;
import com.moop.kmareviews.services.ReviewService;
import com.moop.kmareviews.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService =  teacherService;
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("many")
    public void addTeachers(@RequestBody List<Teacher> teachers) throws NotUniqueTeacherNameException {
       teacherService.addTeachers(teachers);
    }

    @ExceptionHandler(NotUniqueTeacherNameException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public NotUniqueTeacherName handleException(NotUniqueTeacherNameException ex) {
        return new NotUniqueTeacherName(ex.getTeachers(), "Not unique names");
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){ return teacherService.getAllTeachers();}

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable("id") Teacher teacher){
        return teacher;
    }

    @GetMapping("{id}/reviews")
    public List<Review> getReviewsByTeacher(@PathVariable("id") Teacher teacher){
        return teacherService.getReviewsByTeacher(teacher);
    }
}
