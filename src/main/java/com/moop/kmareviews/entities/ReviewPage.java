package com.moop.kmareviews.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReviewPage {
    private List<Review> reviews;
    private int currentPage;
    private int totalPages;
}
