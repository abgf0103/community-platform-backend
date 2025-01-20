package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.mapper.UserMapper;
import com.example.communityplatformbackend.model.UserVO;

import com.example.communityplatformbackend.model.entity.UserEntity;
import com.example.communityplatformbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;

    public List<UserVO> selectAllUsers() {
        return userMapper.selectAllUsers();
    }


    public String getNicknameByID(Long memberID) {
        return userMapper.getNicknameByID(memberID);
    }

    public void signUpUser(UserVO userVO) {
        String encryptedPassword = passwordEncoder.encode(userVO.getPassword());
        userVO.setPassword(encryptedPassword);
        userMapper.signUpUser(userVO);
    }

    public boolean loginUser(UserVO userVO) {
        UserVO user = userMapper.findByUsername(userVO.getUsername());
        return passwordEncoder.matches(userVO.getPassword(), user.getPassword());
    }

    // jpa test
    public UserEntity registerUser(UserVO userVO) {
        UserEntity userEntity = new UserEntity(
                userVO.getUsername(),
                userVO.getNickname(),
                userVO.getEmail(),
                userVO.getPassword()
        );
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
