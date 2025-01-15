package com.example.communityplatformbackend.mapper;

import com.example.communityplatformbackend.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVO> selectAllUsers();
    UserVO findByUsername(@Param("username") String username);
    String getNicknameByID(Long memberID);
    void signUpUser(UserVO userVO);
    UserVO loginUser(UserVO userVO);
}
