package com.moop.kmareviews.server_side.dto;

import com.moop.kmareviews.db_side.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReviewPageDTO {
    private List<Review> reviews;
    private int currentPage;
    private int totalPages;
}
