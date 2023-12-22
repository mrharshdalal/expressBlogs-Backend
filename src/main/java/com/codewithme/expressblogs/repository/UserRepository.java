package com.codewithme.expressblogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithme.expressblogs.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
