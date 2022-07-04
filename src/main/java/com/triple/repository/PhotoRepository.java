package com.triple.repository;

import com.triple.domain.Photo;
import com.triple.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
