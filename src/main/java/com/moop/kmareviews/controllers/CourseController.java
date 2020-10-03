package com.moop.kmareviews.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.moop.kmareviews.entities.Course;
import com.moop.kmareviews.entities.Views;
import com.moop.kmareviews.services.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("course")
public class CourseController {

    private final ReviewService reviewService;

    public CourseController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/many")
    @JsonView(Views.Brief.class)
    public void addTeachers(@RequestBody Set<Course> courses){
        reviewService.addCourses(courses);
    }

    @PostMapping
    @JsonView(Views.Brief.class)
    public Course addCourse(@RequestBody Course course){
        return reviewService.addCourse(course);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        reviewService.deleteCourse(id);
    }
    @GetMapping("{id}")
    @JsonView(Views.FullCourse.class)
    public Course getCourse(@PathVariable("id") Course course){
        return course;
    }

}
