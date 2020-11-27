package com.moop.kmareviews.services;

import com.moop.kmareviews.db_side.entities.Review;
import com.moop.kmareviews.server_side.dto.ReviewPageDTO;
import com.moop.kmareviews.db_side.entities.Teacher;
import com.moop.kmareviews.db_side.repositories.ReviewRepo;
import com.moop.kmareviews.db_side.repositories.TeacherRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Review> getAllReviews(Teacher teacher) {
        if(teacher != null) return reviewRepo.findByTeacher(teacher);
        return reviewRepo.findAll();
    }

    public ReviewPageDTO getAllReviews(Pageable pageable, Long teacherId, Long facultyId) {
        Page<Review> p;
        if(teacherId != null) p = reviewRepo.findByTeacher(teacherId, pageable);
        else if(facultyId != null)  {
            List<Review> reviews =  reviewRepo.findAll();
            reviews.sort(Comparator.comparing(Review::getId).reversed());
            List<Review> filtered = new LinkedList<>();
            for( Review r : reviews) if(r.getTeacher()!=null && r.getTeacher().getFaculty() != null && r.getTeacher().getFaculty().getId().equals(facultyId)) filtered.add(r);
            p = new PageImpl<>(filtered, pageable, reviews.size());
        }
        else p = reviewRepo.findAll(pageable);
        return new ReviewPageDTO(p.getContent(), p.getNumber(), p.getTotalPages());
    }
    public ReviewPageDTO getAllReviews(Pageable pageable) {
        return getAllReviews(pageable,null,null);
    }

    public void deleteReview(Long reviewId){    reviewRepo.deleteById(reviewId); }
    public void deleteAllReviews(){    reviewRepo.deleteAll(); }

}
