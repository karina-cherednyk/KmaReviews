package com.moop.kmareviews.server_side.controllers;
import com.moop.kmareviews.server_side.dto.NotUniqueNameDTO;
import com.moop.kmareviews.server_side.dto.TeacherPageDTO;
import com.moop.kmareviews.db_side.entities.Faculty;
import com.moop.kmareviews.db_side.entities.Teacher;
import com.moop.kmareviews.server_side.exceptions.NotUniqueNameException;
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



    @PostMapping("many")
    public void addTeachers(@RequestBody List<Teacher> teachers) throws NotUniqueNameException {
       teacherService.addTeachers(teachers);
    }

    @ExceptionHandler(NotUniqueNameException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public NotUniqueNameDTO handleException(NotUniqueNameException ex) {
        return new NotUniqueNameDTO(ex.getNames(), "Not unique teacher names");
    }

    @GetMapping("all")
    public List<Teacher> getAllTeachers(@RequestParam(value = "faculty_id", required = false) Faculty faculty){ return teacherService.getAllTeachers(faculty);}

    @DeleteMapping
    public void deleteTeacher(@RequestParam("teacher_id") Long id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping
    public Teacher getTeacher(@RequestParam("teacher_id") Teacher teacher){
        return teacher;
    }



    @PutMapping
    public Teacher updateTeacherFaculty(@RequestParam("teacher_id") Teacher teacher, @RequestParam("faculty_id")Faculty faculty) throws NotUniqueNameException {
        teacher.setFaculty(faculty);
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("pageable")
    public TeacherPageDTO getAllTeachers(
            @PageableDefault(size = PER_PAGE, sort = { "name" }, direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(value = "faculty_id", required = false) Long facultyId
    ) {
        return teacherService.getAllTeachers(facultyId, pageable);
    }



}
