package com.moop.kmareviews.services;

import com.moop.kmareviews.server_side.dto.FacultyPageDTO;
import com.moop.kmareviews.db_side.entities.Faculty;
import com.moop.kmareviews.server_side.exceptions.NotUniqueNameException;
import com.moop.kmareviews.db_side.repositories.FacultyRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


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

    public List<Faculty> getAllFaculties(){
        List<Faculty> fs = facultyRepo.findAll();
        fs.sort(Comparator.comparing(Faculty::getName));
        return fs;
    }
    public FacultyPageDTO getAllFaculties(Pageable pageable) {
        Page<Faculty> p = facultyRepo.findAll(pageable);
        return new FacultyPageDTO(p.getContent(), p.getNumber(), p.getTotalPages());
    }
    public Optional<Faculty> getById(Long id){
        return facultyRepo.findById(id);
    }
}
