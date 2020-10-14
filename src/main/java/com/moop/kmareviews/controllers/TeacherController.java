package com.moop.kmareviews.controllers;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    private final ReviewService reviewService;

    public TeacherController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return reviewService.addTeacher(teacher);
    }

    @PostMapping("many")
    public void addTeachers(@RequestBody Set<Teacher> teachers){
        System.out.println(teachers);
       reviewService.addTeachers(teachers);
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){ return reviewService.getAllTeachers();}

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable Long id){
        reviewService.deleteTeacher(id);
    }

    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable("id") Teacher teacher){
        return teacher;
    }
}
