package com.example.communityplatformbackend.controller;

import com.example.communityplatformbackend.model.UserVO;
import com.example.communityplatformbackend.model.entity.UserEntity;
import com.example.communityplatformbackend.repository.UserRepository;
import com.example.communityplatformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jpa/user")
public class UserJpaController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public UserEntity registerUser(@RequestBody UserVO userVO) {
        return userService.registerUser(userVO);
    }
}
