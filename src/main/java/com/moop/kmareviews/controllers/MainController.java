package com.moop.kmareviews.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.moop.kmareviews.entities.ReviewPage;
import com.moop.kmareviews.entities.Views;
import com.moop.kmareviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    private final ReviewService reviewService;
    private final ObjectWriter reviewWriter;

    @Value("${activeProfile:prod}")
    private String profile;

    public MainController(ReviewService reviewService, ObjectMapper mapper) {
        this.reviewService = reviewService;

        ObjectMapper objectMapper = mapper
                .setConfig(mapper.getSerializationConfig());

        this.reviewWriter = objectMapper.writerWithView(Views.Full.class);
    }

    @GetMapping
    public String main(Model model) throws JsonProcessingException {


        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        PageRequest pageRequest = PageRequest.of(0, ReviewController.PER_PAGE, sort);
        ReviewPage reviewPage = reviewService.getAllReviews(pageRequest);

        String reviews = reviewWriter.writeValueAsString(reviewPage.getReviews());

        model.addAttribute("isDevMode", "dev".equals(profile));
        model.addAttribute("reviews", reviews);
        model.addAttribute("pageNumber", reviewPage.getCurrentPage());
        model.addAttribute("totalPages", reviewPage.getTotalPages());

        return "index";
    }
}
