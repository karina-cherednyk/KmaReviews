package com.moop.kmareviews.controllers;
import com.moop.kmareviews.dto.NotUniqueName;
import com.moop.kmareviews.dto.TeacherPage;
import com.moop.kmareviews.entities.Faculty;
import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.exceptions.NotUniqueNameException;
import com.moop.kmareviews.services.TeacherService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    public static final int PER_PAGE = 5;

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService =  teacherService;
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) throws NotUniqueNameException {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/{tid}/to/{fid}")
    public Teacher updateTeacherFaculty(@PathVariable("tid") Teacher teacher, @PathVariable("fid")Faculty faculty) throws NotUniqueNameException {
        teacher.setFaculty(faculty);
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("many")
    public void addTeachers(@RequestBody List<Teacher> teachers) throws NotUniqueNameException {
       teacherService.addTeachers(teachers);
    }

    @ExceptionHandler(NotUniqueNameException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public NotUniqueName handleException(NotUniqueNameException ex) {
        return new NotUniqueName(ex.getNames(), "Not unique teacher names");
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


    @GetMapping("page")
    public TeacherPage getAllTeachers(
            @PageableDefault(size = PER_PAGE, sort = { "name" }, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return teacherService.getAllTeachersPageable(pageable);
    }

    @GetMapping("from/{fid}/page")
    public TeacherPage getAllTeachersPageable(
            @PageableDefault(size = PER_PAGE, sort = { "name" }, direction = Sort.Direction.ASC) Pageable pageable, @PathVariable("fid") Long facultyId
    ) {
        return teacherService.getAllTeachersByFacultyPageable(facultyId, pageable);
    }

    @GetMapping("from/{fid}")
    public List<Teacher> getAllTeachers(
            @PathVariable("fid") Faculty faculty
    ) {
        return teacherService.getAllTeachers(faculty);
    }
}
