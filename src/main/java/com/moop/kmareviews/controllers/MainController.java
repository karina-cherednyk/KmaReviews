package com.moop.kmareviews.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.moop.kmareviews.dto.ReviewPage;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.services.ReviewService;
import com.moop.kmareviews.services.TeacherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final ReviewService reviewService;
    private final TeacherService teacherService;
    private final ObjectWriter reviewWriter;

    @Value("${activeProfile:prod}")
    private String profile;

    public MainController(ReviewService reviewService, ObjectMapper mapper, TeacherService teacherService) {
        this.reviewService = reviewService;
        this.teacherService = teacherService;
        ObjectMapper objectMapper = mapper.setConfig(mapper.getSerializationConfig());
        this.reviewWriter = objectMapper.writer();
    }

    @GetMapping
    public String main(Model model) throws JsonProcessingException {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        PageRequest pageRequest = PageRequest.of(0, ReviewController.PER_PAGE, sort);
        ReviewPage reviewPage = reviewService.getAllReviews(pageRequest);
        List<Teacher> teacherList = teacherService.getAllTeachers();

        String reviews = reviewWriter.writeValueAsString(reviewPage.getReviews());
        String teachers = reviewWriter.writeValueAsString(teacherList);

        model.addAttribute("isDevMode", "dev".equals(profile));
        model.addAttribute("reviews", reviews);
        model.addAttribute("teachers", teachers);
        model.addAttribute("pageNumber", reviewPage.getCurrentPage());
        model.addAttribute("totalPages", reviewPage.getTotalPages());

        return "index";
    }

}
