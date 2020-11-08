package com.moop.kmareviews.controllers;

import com.moop.kmareviews.dto.FacultyPageDTO;
import com.moop.kmareviews.dto.NotUniqueNameDTO;
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

    @PostMapping("all")
    public void addFaculties(@RequestBody List<Faculty> faculties) throws NotUniqueNameException {
        facultyService.addFaculties(faculties);
    }

    @PostMapping
    public void addFaculty(@RequestBody Faculty faculty) throws NotUniqueNameException {
        facultyService.addFaculty(faculty);
    }

    @DeleteMapping
    public void deleteFaculty(@RequestParam("faculty_id") Long id){facultyService.deleteFaculty(id);}


    @GetMapping("all")
    public List<Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();
    }

    @GetMapping("pageable")
    public FacultyPageDTO getAllFacultiesPageable(
            @PageableDefault(size = PER_PAGE, sort = { "name" }, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return facultyService.getAllFaculties(pageable);
    }

    @ExceptionHandler(NotUniqueNameException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public NotUniqueNameDTO handleException(NotUniqueNameException ex) {
        return new NotUniqueNameDTO(ex.getNames(), "Not unique faculty names");
    }
}
