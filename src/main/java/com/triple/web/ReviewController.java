//package com.triple.web;
//
//import com.triple.domain.Review;
//import com.triple.service.ReviewService;
//import com.triple.web.dto.ReviewModRequestDto;
//import com.triple.web.dto.ReviewResponseDto;
//import com.triple.web.dto.ReviewSaveRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/event")
//public class ReviewController {
//    private final ReviewService reviewService;
//
//            //리뷰 생성
//        /*//    @PostMapping("/list")
//        //    public Map<String, String> getCreateReview(@RequestBody ReviewSaveRequestDto){
//        //
//        //    }*/
//    //리뷰 수정
//    @PutMapping
//    public String getUpdate(@PathVariable UUID reviewId, @RequestBody ReviewModRequestDto requestDto){
//        return "리뷰 수정";
//    }
//    //리뷰 리턴
////    @GetMapping("/list/{id}")
////    public Object reviewList(@PathVariable String id){
////
////        Review review = new Review();
////            review.reviewId= UUID.fromString("11");
////            review.getContent() = "dd";
////
////            return list;
////        }
//}