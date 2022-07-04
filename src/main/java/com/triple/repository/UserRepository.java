package com.triple.repository;

import com.triple.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findByUserId(String userId);
}
