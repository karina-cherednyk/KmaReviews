package com.moop.kmareviews.controllers;

import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.repositories.ReviewRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("review")
public class ReviewController {
    private final ReviewRepo reviewRepo;

    public ReviewController(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        review.setSendTime(LocalDateTime.now());
        return reviewRepo.save(review);
    }

    List<Review> list = new LinkedList<Review>()
    {{
        add(new Review(null, "sdsd", "sdasd", null));
        add(new Review(null, "sdsjkkjd", "sdasjljld", null));

    }};
    @GetMapping
    public List<Review> getAllReviews(){
        return list;
    }
}
