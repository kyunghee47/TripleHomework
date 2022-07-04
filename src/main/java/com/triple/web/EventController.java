package com.triple.web;

import com.triple.domain.Review;
import com.triple.repository.ReviewRepository;
import com.triple.service.ReviewService;
import com.triple.web.params.ReveiwUpdateEventParams;
import com.triple.web.type.ActionType;
import com.triple.web.params.ReveiwWriteEventParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final ReviewService reviewService;

    private final ReviewRepository repo;
    @PostMapping("/events")
    public void events(ReveiwWriteEventParams eventParams) {

        if (eventParams.getAction() == ActionType.ADD) {
            reviewService.addReview(eventParams);

        }
    }
    @PutMapping("/mod/{id}")
    public void modEvents(@PathVariable Long id, ReveiwWriteEventParams eventParams) {

        if (eventParams.getAction() == ActionType.MOD) {
            reviewService.modReview(id, eventParams);
        }

    }
    @DeleteMapping("/delete/{id}")
    public void deleteEvents(@PathVariable Long id, ReveiwWriteEventParams eventParams) {
        if (eventParams.getAction() == ActionType.DELETE) {
            reviewService.deleteReview(id);
        }
    }
    @GetMapping("/events/{id}")
    public Review getAccount(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("illegal argument :" + id));
    }
}
