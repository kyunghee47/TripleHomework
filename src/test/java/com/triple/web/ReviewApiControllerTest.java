//package com.triple.web;
//
//import com.triple.domain.Review;
//import com.triple.domain.ReviewRepository;
//import com.triple.web.dto.ReviewModRequestDto;
//import com.triple.web.dto.ReviewSaveRequestDto;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ReviewApiControllerTest {
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @After
//    public void tearDown() throws Exception{
//        reviewRepository.deleteAll();
//    }
//
//    @Test
//    public void 리뷰등록() throws Exception{
//
//        String reviewId = "uuid";
//        String content = "좋아요";
//
//        ReviewSaveRequestDto requestDto = ReviewSaveRequestDto.builder()
//                .reviewId(reviewId).content(content).build();
//
//        String url = "http://localhost:"+port+"/event";
//
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity
//                (url,requestDto,Long.class);
//
//        assertThat(responseEntity
//                .getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0l);
//
//        List<Review> all = reviewRepository.findAll();
//        assertThat(all.get(0).getReviewId()).isEqualTo(reviewId);
//        assertThat(all.get(0).getContent()).isEqualTo(content);
//    }
//
//    @Test
//    public void 리뷰수정() throws Exception{
//        Review saveReview = reviewRepository.save(Review.builder()
//                        .reviewId("dfddfgdfd")
//                        .content("싫어요")
//                .build());
//
//        Long updateId = saveReview.getId();
//        String expectedId = "다시 좋아용";
//        String expectedContent = "개빡쳥";
//
//        ReviewModRequestDto requestDto =
//                ReviewModRequestDto.builder()
//                        .reviewId(expectedId)
//                        .content(expectedContent)
//                        .build();
//
//        String url = "http://localhost:"+port+"/event/"+updateId;
//        HttpEntity<ReviewModRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(
//                url, HttpMethod.PUT,requestEntity,Long.class
//        );
//        assertThat(responseEntity
//                .getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0l);
//
//        List<Review> all = reviewRepository.findAll();
//        assertThat(all.get(0).getReviewId()).isEqualTo(expectedId);
//        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
//
//    }
//}
