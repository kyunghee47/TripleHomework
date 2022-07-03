//package com.triple.domain;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.assertj.core.api.Assertions.assertThat;
//import java.util.List;
//import java.util.UUID;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ReviewRepositoryTest {
//
//    @Autowired
//    ReviewRepository reviewRepository;
//
//    @Autowired
//    UserRepository userRepository;
//    private User userId;
//
//    @After
//    public void cleanup(){
//        reviewRepository.deleteAll();
//    }
//    @Test
//    public void 유저조회(){
//        String userId = "uiud";
//        userRepository.save(User.builder().userId(userId).build());
//    }
//    @Test
//    public void 리뷰조회(){
//
//        String content = "좋아요";
//
//        UUID reviewId = null;
//        reviewRepository.save(Review.builder()
//                        .reviewId(reviewId)
//                        .content(content)
//                        .userId(userId)
//                        .build());
//    List<Review> reviewList = reviewRepository.findAll();
//    Review review = reviewList.get(0);
//    assertThat(review.getReviewId()).isEqualTo(reviewId);
//    assertThat(review.getContent()).isEqualTo(content);
//
//    }
//}
