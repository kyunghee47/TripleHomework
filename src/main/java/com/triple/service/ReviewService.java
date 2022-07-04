package com.triple.service;

import com.triple.domain.*;
import com.triple.repository.PhotoRepository;
import com.triple.repository.PlaceRepository;
import com.triple.repository.ReviewRepository;
import com.triple.repository.UserRepository;

import com.triple.web.params.ReveiwWriteEventParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final PhotoRepository photoRepository;
    @Transactional
    public void addReview(ReveiwWriteEventParams eventParams) {

        List<Photo> photos = new ArrayList<>();
        Review review = reviewRepository.findByReviewId(eventParams.getReveiwId());

        User user = userRepository.findByUserId(eventParams.getUserId());

        Place place = placeRepository.findByPlaceId(eventParams.getPlaceId());


        if(eventParams.getContent().length()>1 || eventParams.getAttachedPhotoIds().size()>1){
            review.setReviewPoint(review.getReviewPoint()+1);}
        else if (eventParams.getContent().length()>1 && eventParams.getAttachedPhotoIds().size()>1) {
            review.setReviewPoint(review.getReviewPoint()+2);
        }


        Review reviews = Review.builder()
                .reviewId(eventParams.getReveiwId())
                .content(eventParams.getContent())
                .user(user)
                .place(place)
                .build();

        for (String eventId : eventParams.getAttachedPhotoIds()) {
            photos.add(Photo.of(eventId, reviews));
        }

        reviewRepository.save(reviews);
        photoRepository.saveAll(photos);
    }


    @Transactional
    public void modReview(Long id,ReveiwWriteEventParams eventParams) {
        Review review = reviewRepository.findByReviewId(eventParams.getReveiwId());
        //Review review = reviewRepository.findById(id);
        reviewRepository.save(review);

    }
    @Transactional
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id).get();
        reviewRepository.delete(review);


    }
}
