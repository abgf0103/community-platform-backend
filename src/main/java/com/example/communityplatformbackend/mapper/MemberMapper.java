package com.example.communityplatformbackend.mapper;

import com.example.communityplatformbackend.model.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberVO> selectAllUsers();
    String getNicknameByID(Long memberID);
}
