package com.moop.kmareviews.services;

import com.moop.kmareviews.entities.Course;
import com.moop.kmareviews.entities.Review;
import com.moop.kmareviews.dto.ReviewPage;
import com.moop.kmareviews.entities.Teacher;
import com.moop.kmareviews.repositories.ReviewRepo;
import com.moop.kmareviews.repositories.TeacherRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final TeacherRepo teacherRepo;

    public ReviewService(ReviewRepo reviewRepo, TeacherRepo teacherRepo) {
        this.reviewRepo = reviewRepo;
        this.teacherRepo = teacherRepo;
    }

    @Transactional
    public Review addReview(Review review) {
        review.setSendTime(LocalDateTime.now());

        Teacher teacher = review.getTeacher();
        Teacher dbTeacher = null;
        if(teacher != null)     {
            dbTeacher = teacherRepo.getOne(teacher.getId());
            review.setTeacher(dbTeacher);
        }

        return reviewRepo.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public ReviewPage getAllReviews(Pageable pageable) {
        Page<Review> p = reviewRepo.findAll(pageable);
        return new ReviewPage(p.getContent(), p.getNumber(), p.getTotalPages());
    }


    public void deleteReview(Long reviewId){    reviewRepo.deleteById(reviewId); }
    public void deleteAllReviews(){    reviewRepo.deleteAll(); }


}
