package com.moop.kmareviews.server_side.controllers;

import com.moop.kmareviews.server_side.dto.ReviewPageDTO;
import com.moop.kmareviews.db_side.entities.Review;
import com.moop.kmareviews.db_side.entities.Teacher;
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
    public static final int PER_PAGE = 5;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }

    @GetMapping("all")
    public List<Review> getAllReviews(@RequestParam(value = "teacher_id", required = false)Teacher teacher){
        return reviewService.getAllReviews(teacher);
    }

    @GetMapping("pageable")
    public ReviewPageDTO getAllReviews(
            @PageableDefault(size = PER_PAGE, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "teacher_id", required = false) Long teacherId,   @RequestParam(value = "faculty_id", required = false) Long facultyId
    ) {
        return reviewService.getAllReviews(pageable, teacherId, facultyId);
    }



    @DeleteMapping
    public void deleteReview(@RequestParam("review_id") Long id){reviewService.deleteReview(id);}

    @DeleteMapping("all")
    public void deleteAllReviews(){ reviewService.deleteAllReviews();}

    @GetMapping
    public Review getReview(@RequestParam("review_id") Review review){
        return review;
    }
}
