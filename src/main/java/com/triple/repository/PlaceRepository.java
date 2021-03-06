package com.triple.repository;

import com.triple.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByPlaceId(String placeId);
}
