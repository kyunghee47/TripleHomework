package com.triple.web;

import com.triple.domain.Review;
import com.triple.domain.ReviewRepository;
import com.triple.service.ReviewService;
import com.triple.web.dto.ReviewModRequestDto;
import com.triple.web.dto.ReviewResponseDto;
import com.triple.web.dto.ReviewSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class ReviewApiController {
    private final ReviewService reviewService;
    private final ReviewRepository repo;

    //리뷰 생성
//    @PostMapping
//    public Long save(@RequestBody ReviewSaveRequestDto requestDto){
//        return reviewService.savedReview(requestDto,reviewId);
//    }
    //리뷰 수정
//    @PutMapping
//    public UUID update(@PathVariable UUID reviewId, @RequestBody ReviewModRequestDto requestDto){
//        return reviewService.update(reviewId,requestDto);
//    }
    //리뷰뷰 리턴
    @GetMapping("event/list/{id}")
    public ReviewResponseDto findById(@PathVariable Long id){
        ReviewResponseDto review = reviewService.findById(id);
        System.out.print(review);

        return review;
    }
    @PostMapping("/post")
    public Long save(@RequestBody final ReviewSaveRequestDto params) {
        return reviewService.save(params);
    }
}
