package com.triple.web.dto;

import com.triple.domain.Place;
import com.triple.domain.Review;
import com.triple.domain.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ReviewResponseDto {

    private UUID reviewId;
    private String content;

    private int reviewPoint;

    private User userId;

    private Place placeId;

    public ReviewResponseDto(Review entity){

        this.reviewId = entity.getReviewId();
        this.content = entity.getContent();
        this.reviewPoint = entity.getReviewPoint();
        this.userId = entity.getUser();
        this.placeId = entity.getPlace();
    }
}
