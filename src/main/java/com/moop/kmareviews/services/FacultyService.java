package com.moop.kmareviews.services;

import com.moop.kmareviews.dto.FacultyPage;
import com.moop.kmareviews.entities.Faculty;
import com.moop.kmareviews.exceptions.NotUniqueNameException;
import com.moop.kmareviews.repositories.FacultyRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class FacultyService {
    public final FacultyRepo facultyRepo;

    public FacultyService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public void addFaculties(List<Faculty> faculties) throws NotUniqueNameException {
        List<String> notUnique = new LinkedList<>();
        for (Faculty faculty: faculties){
            try{
                facultyRepo.save(faculty);
            }catch (DataIntegrityViolationException e){
                notUnique.add(faculty.getName());
            }
        }
        if(! notUnique.isEmpty()) throw new NotUniqueNameException(notUnique);

    }
    public Faculty addFaculty(Faculty faculty) throws NotUniqueNameException {
        try {
            return facultyRepo.save(faculty);
        } catch (DataIntegrityViolationException e){
            List<String> l = new LinkedList<>();
            l.add(faculty.getName());
            throw new NotUniqueNameException(l);
        }
    }
    public void deleteFaculty(Long facultyId){  facultyRepo.deleteById(facultyId);}
    public List<Faculty> getAllFaculties(){return facultyRepo.findAll();}
    public FacultyPage getAllFacultiesPageable(Pageable pageable) {
        Page<Faculty> p = facultyRepo.findAll(pageable);
        return new FacultyPage(p.getContent(), p.getNumber(), p.getTotalPages());
    }

}
