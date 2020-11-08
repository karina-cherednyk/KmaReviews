package com.moop.kmareviews.services;

import com.moop.kmareviews.dto.TeacherPageDTO;
import com.moop.kmareviews.entities.Faculty;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.exceptions.NotUniqueNameException;
import com.moop.kmareviews.repositories.ReviewRepo;
import com.moop.kmareviews.repositories.TeacherRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;



@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;


    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void addTeachers(List<Teacher> teachers) throws NotUniqueNameException {
        List<String> notUnique = new LinkedList<>();
        for (Teacher teacher : teachers){
            try{
                teacherRepo.save(teacher);
            }catch (DataIntegrityViolationException e){
                notUnique.add(teacher.getName());
            }
        }
        if(! notUnique.isEmpty()) throw new NotUniqueNameException(notUnique);

    }
    public Teacher addTeacher(Teacher teacher) throws NotUniqueNameException {
        try {
            return teacherRepo.save(teacher);
        }
        catch (DataIntegrityViolationException e){
            List<String> l = new LinkedList<>();
            l.add(teacher.getName());
            throw new NotUniqueNameException(l);
        }
    }
    public void deleteTeacher(Long teacherId){  teacherRepo.deleteById(teacherId);}

    public TeacherPageDTO getAllTeachers(Long facultyId, Pageable pageable) {
        Page<Teacher> p;
        if(facultyId == null) p = teacherRepo.findAll(pageable);
        else p = teacherRepo.findByFacultyPageable(facultyId, pageable);
        return new TeacherPageDTO(p.getContent(), p.getNumber(), p.getTotalPages());
    }

    public List<Teacher> getAllTeachers(Faculty faculty) {
        if(faculty == null) return teacherRepo.findAll();
        return teacherRepo.findByFaculty(faculty);
    }
}
