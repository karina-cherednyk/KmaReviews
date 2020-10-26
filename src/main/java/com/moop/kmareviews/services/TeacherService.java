package com.moop.kmareviews.services;

import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.repositories.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void addTeachers(List<Teacher> teachers){
        teacherRepo.saveAll(teachers);
    }
    public Teacher addTeacher(Teacher teacher){ return teacherRepo.save(teacher);   }
    public void deleteTeacher(Long teacherId){  teacherRepo.deleteById(teacherId);}
    public List<Teacher> getAllTeachers(){return teacherRepo.findAll();}
}
