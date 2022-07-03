package com.triple.service;

import com.triple.domain.Review;
import com.triple.domain.ReviewRepository;
import com.triple.domain.User;
import com.triple.domain.UserRepository;
import com.triple.web.dto.ReviewModRequestDto;
import com.triple.web.dto.ReviewResponseDto;
import com.triple.web.dto.ReviewSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

//    @Transactional
//    public Long savedReview(ReviewSaveRequestDto requestDto, Long userId){
//        User user = userRepository.findById(userId)
//                .orElseThrow(()->new IllegalArgumentException("유저없음"));
//        requestDto.setUser(user);
//        return reviewRepository.save(requestDto.toEntity()).getId();
//    }
@Transactional
public Long save(final ReviewSaveRequestDto params) {

    Review entity = reviewRepository.save(params.toEntity());
    return entity.getId();
}


    @Transactional
    public Long update(Long reviewId, ReviewModRequestDto requestDto){
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new
                        IllegalArgumentException("헤당 리뷰가 없습니다."));
        review.update(requestDto.getContent());
        return reviewId;
    }
    public ReviewResponseDto findById(Long reviewId){
        Review entity = reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "해당게시글이 없습니다."
                        ));
        return new ReviewResponseDto(entity);
    }
}
