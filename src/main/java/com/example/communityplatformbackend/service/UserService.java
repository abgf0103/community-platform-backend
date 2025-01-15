package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.mapper.UserMapper;
import com.example.communityplatformbackend.model.UserVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserVO> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    public String getNicknameByID(Long memberID) {
        return userMapper.getNicknameByID(memberID);
    }
}
