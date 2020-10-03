package com.moop.kmareviews.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.entities.Views;
import com.moop.kmareviews.services.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    private final ReviewService reviewService;

    public TeacherController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping
    @JsonView(Views.Brief.class)
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return reviewService.addTeacher(teacher);
    }

    @PostMapping("/many")
    @JsonView(Views.Brief.class)
    public void addTeachers(@RequestBody Set<Teacher> teachers){
       reviewService.addTeachers(teachers);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id){
        reviewService.deleteTeacher(id);
    }

    @GetMapping("{id}")
    @JsonView(Views.FullTeacher.class)
    public Teacher getTeacher(@PathVariable("id") Teacher teacher){
        return teacher;
    }
}
