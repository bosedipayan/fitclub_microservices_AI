package com.fitclub.userService.service;

import com.fitclub.userService.UserRepository;
import com.fitclub.userService.models.User;
import com.fitclub.userService.ures.RegisterRequest;
import com.fitclub.userService.ures.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserResponse registerUser(RegisterRequest request) {
        // Logic to register user and save to database
        // Convert User entity to UserResponse DTO

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());


        User savedUser = new User();
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
}
