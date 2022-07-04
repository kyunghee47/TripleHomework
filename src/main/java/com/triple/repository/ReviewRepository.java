package com.triple.repository;

import com.triple.domain.Review;
import com.triple.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByReviewId(String reviewId);
}
