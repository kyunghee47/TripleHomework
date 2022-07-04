package com.triple.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String reviewId;

    @Column
    private String content;

    @Column
    private int reviewPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name ="place_id")
    private Place place;

    public void setReviewPoint(int reviewPoint) {
        this.reviewPoint = reviewPoint;
    }

    @Builder
    public Review(String reviewId,String content,int reviewPoint, User user,Place place){
        this.reviewId = reviewId;
        this.content = content;
        this.reviewPoint = reviewPoint;
        this.user = user;
        this.place = place;
    }

    public void mod(String reviewId,String content){
        this.reviewId=reviewId;
        this.content=content;
    }

    public void update(String content) {
        this.reviewPoint = reviewPoint;
        this.content=content;
    }
}
