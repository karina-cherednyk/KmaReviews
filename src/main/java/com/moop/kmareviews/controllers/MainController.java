package com.moop.kmareviews.controllers;

import com.moop.kmareviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    private final ReviewService reviewService;

    @Value("${spring.profiles.active:prod}")
    private String profile;

    public MainController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String main(Model model){
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
