package com.codewithme.expressblogs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithme.expressblogs.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> getUserByEmail(String email);
    
}
