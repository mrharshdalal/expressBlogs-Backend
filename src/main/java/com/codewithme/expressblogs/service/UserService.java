package com.codewithme.expressblogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithme.expressblogs.exception.UserNotFoundException;
import com.codewithme.expressblogs.model.User;
import com.codewithme.expressblogs.repository.UserRepository;


@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email)
        .orElseThrow(() -> new UserNotFoundException("User with email" + email + " was not found."));
    }

}