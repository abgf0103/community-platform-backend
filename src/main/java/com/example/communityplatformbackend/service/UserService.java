package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.mapper.UserMapper;
import com.example.communityplatformbackend.model.UserVO;

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
        String encryptedPassword = passwordEncoder.encode(userVO.getPassword());
        userVO.setPassword(encryptedPassword);
        log.info("맞춰야 하는 암호화된 비밀번호 : " + user.getPassword());
        log.info("시도하는 암호화된 비밀번호 : "+encryptedPassword);
        if(user == null){
            log.info("false");
        }

        return true;
    }
}
