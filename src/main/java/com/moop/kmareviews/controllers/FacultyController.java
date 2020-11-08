package com.moop.kmareviews.controllers;

import com.moop.kmareviews.dto.FacultyPage;
import com.moop.kmareviews.dto.NotUniqueName;
import com.moop.kmareviews.entities.Faculty;
import com.moop.kmareviews.exceptions.NotUniqueNameException;
import com.moop.kmareviews.services.FacultyService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("faculty")
public class FacultyController {
    public static final int PER_PAGE = 5;

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("many")
    public void addFaculties(@RequestBody List<Faculty> faculties) throws NotUniqueNameException {
        facultyService.addFaculties(faculties);
    }

    @PostMapping
    public void addFaculty(@RequestBody Faculty faculty) throws NotUniqueNameException {
        facultyService.addFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public void deleteFaculty(@PathVariable Long id){facultyService.deleteFaculty(id);}


    @GetMapping
    public List<Faculty> getAllFaculties(){ return facultyService.getAllFaculties();}

    @GetMapping("page")
    public FacultyPage getAllFacultiesPageable(
            @PageableDefault(size = PER_PAGE, sort = { "name" }, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return facultyService.getAllFacultiesPageable(pageable);
    }

    @ExceptionHandler(NotUniqueNameException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public NotUniqueName handleException(NotUniqueNameException ex) {
        return new NotUniqueName(ex.getNames(), "Not unique faculty names");
    }
}
