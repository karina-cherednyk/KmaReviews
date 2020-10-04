package com.moop.kmareviews.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.entities.ReviewPage;
import com.moop.kmareviews.entities.Views;
import com.moop.kmareviews.services.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("review")
public class ReviewController {
    private final ReviewService reviewService;
    public static final int PER_PAGE = 10;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @JsonView(Views.Full.class)
    public Review addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }

    @GetMapping
    @JsonView(Views.Full.class)
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("page")
    @JsonView(Views.Full.class)
    public ReviewPage getAllReviews(
            @PageableDefault(size = PER_PAGE, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return reviewService.getAllReviews(pageable);
    }

    @DeleteMapping("{id}")
    public void deleteReview(@PathVariable Long id){reviewService.deleteReview(id);}

    @GetMapping("{id}")
    @JsonView(Views.Full.class)
    public Review getReview(@PathVariable("id") Review review){
        return review;
    }
}
