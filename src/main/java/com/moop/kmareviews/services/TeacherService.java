package com.moop.kmareviews.services;

import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.exceptions.NotUniqueTeacherNameException;
import com.moop.kmareviews.repositories.ReviewRepo;
import com.moop.kmareviews.repositories.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;



@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;
    private final ReviewRepo reviewRepo;

    public TeacherService(TeacherRepo teacherRepo, ReviewRepo reviewRepo) {
        this.teacherRepo = teacherRepo;
        this.reviewRepo = reviewRepo;
    }

    public void addTeachers(List<Teacher> teachers) throws NotUniqueTeacherNameException {
        List<String> notUnique = new LinkedList<>();
        for (Teacher teacher : teachers){
            try{
                teacherRepo.save(teacher);
            }catch (DataIntegrityViolationException e){
                notUnique.add(teacher.getName());
            }
        }
        if(! notUnique.isEmpty()) throw new NotUniqueTeacherNameException(notUnique);

    }
    public Teacher addTeacher(Teacher teacher){ return teacherRepo.save(teacher);   }
    public void deleteTeacher(Long teacherId){  teacherRepo.deleteById(teacherId);}
    public List<Teacher> getAllTeachers(){return teacherRepo.findAll();}
    public List<Review> getReviewsByTeacher(Teacher t){
        return reviewRepo.findReviewByTeacher(t);
    }
}
