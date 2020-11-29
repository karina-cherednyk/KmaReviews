package com.moop.kmareviews.services;

import com.moop.kmareviews.db_side.repositories.FacultyRepo;
import com.moop.kmareviews.server_side.dto.TeacherPageDTO;
import com.moop.kmareviews.db_side.entities.Faculty;
import com.moop.kmareviews.db_side.entities.Teacher;
import com.moop.kmareviews.server_side.exceptions.NotUniqueNameException;
import com.moop.kmareviews.db_side.repositories.TeacherRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;



@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;
    private final FacultyRepo facultyRepo;


    public TeacherService(TeacherRepo teacherRepo, FacultyRepo facultyRepo) {
        this.teacherRepo = teacherRepo;
        this.facultyRepo = facultyRepo;
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
        if(faculty == null) return getAllTeachers();
        List<Teacher> ts =  teacherRepo.findByFaculty(faculty);
        ts.sort(Comparator.comparing(Teacher::getName));
        return  ts;
    }
    public List<Teacher> getAllTeachers() {
        List<Teacher> ts =  teacherRepo.findAll();
        ts.sort(Comparator.comparing(Teacher::getName));
        return  ts;
    }

    public Teacher updateTeacher(Teacher teacher) throws Exception, NotUniqueNameException {
        Optional<Teacher> t = teacherRepo.findById(teacher.getId());
        if(t.isEmpty()) throw new Exception("Teacher not found");
        Teacher res = t.get();
        if(teacher.getFaculty() == null && teacher.getName() == null)  return res;
        if(teacher.getFaculty() != null) {
            Optional<Faculty> f = facultyRepo.findById(teacher.getFaculty().getId());
            if(f.isPresent())  res.setFaculty(f.get());
        }
        if(teacher.getName() != null) res.setName(teacher.getName());
        return  addTeacher(res);
    }
}
