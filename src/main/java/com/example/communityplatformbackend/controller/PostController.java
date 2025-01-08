package com.example.communityplatformbackend.controller;

import com.example.communityplatformbackend.model.PostVO;
import com.example.communityplatformbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public List<PostVO> getAllPosts() {
        return postService.getPostList();
    }
}
