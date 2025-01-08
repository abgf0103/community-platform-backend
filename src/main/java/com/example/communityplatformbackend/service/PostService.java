package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.mapper.PostMapper;
import com.example.communityplatformbackend.model.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostMapper postMapper;

    @Autowired
    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<PostVO> getPostList(){
        return postMapper.getPostList();
    }
}
