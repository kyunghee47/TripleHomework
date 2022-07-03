package com.triple.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ReviewModRequestDto {
    private UUID reviewId;
    private String content;

    @Builder
    public ReviewModRequestDto(UUID reviewId, String content){
        this.reviewId=reviewId;
        this.content=content;
    }
}
