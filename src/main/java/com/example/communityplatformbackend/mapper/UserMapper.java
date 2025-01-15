package com.example.communityplatformbackend.mapper;

import com.example.communityplatformbackend.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVO> selectAllUsers();
    String getNicknameByID(Long memberID);
}
