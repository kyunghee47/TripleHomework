package com.triple.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String photoId;


    @JoinColumn(name = "review_id")
    @ManyToOne
    private Review review;

    @Builder(access = AccessLevel.PRIVATE)
    private Photo(String photoId, Review review) {
        this.photoId = photoId;
        this.review = review;
    }

    public static Photo of(String photoId, Review review) {
        return Photo.builder()
                .photoId(photoId)
                .review(review)
                .build();
    }
}
