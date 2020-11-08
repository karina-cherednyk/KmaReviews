package com.moop.kmareviews.services;

import com.moop.kmareviews.dto.TeacherPage;
import com.moop.kmareviews.entities.Faculty;
import com.moop.kmareviews.entities.Review;
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
    private final ReviewRepo reviewRepo;


    public TeacherService(TeacherRepo teacherRepo, ReviewRepo reviewRepo) {
        this.teacherRepo = teacherRepo;
        this.reviewRepo = reviewRepo;
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
    public List<Teacher> getAllTeachers(){return teacherRepo.findAll();}
    public List<Review> getReviewsByTeacher(Teacher t){
        return reviewRepo.findReviewByTeacher(t);
    }


    public TeacherPage getAllTeachersPageable(Pageable pageable) {
        Page<Teacher> p = teacherRepo.findAll(pageable);
        return new TeacherPage(p.getContent(), p.getNumber(), p.getTotalPages());
    }

    public TeacherPage getAllTeachersByFacultyPageable(Long facultyId, Pageable pageable) {
        Page<Teacher> p = teacherRepo.findByFacultyPageable(facultyId, pageable);
        return new TeacherPage(p.getContent(), p.getNumber(), p.getTotalPages());
    }

    public List<Teacher> getAllTeachers(Faculty faculty) {
        return teacherRepo.findByFaculty(faculty);
    }
}
