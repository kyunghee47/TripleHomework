package com.triple.web.dto;

import com.triple.domain.Review;
import com.triple.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ReviewSaveRequestDto {

    private String content;
    private int reviewPoint;

    private User user;

    public void setUser(User user){
        this.user = user;
    }

    @Builder
    public ReviewSaveRequestDto(String content, int reviewPoint,User user){
        this.content = content;
        this.reviewPoint =reviewPoint;
        this.user = user;
    }
    public Review toEntity(){
        return Review.builder()
                .content(content)
                .reviewPoint(reviewPoint)
                .user(user)
                .build();
    }
}
