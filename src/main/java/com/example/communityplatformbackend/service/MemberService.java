package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.mapper.MemberMapper;
import com.example.communityplatformbackend.model.MemberVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberVO> selectAllUsers() {
        return memberMapper.selectAllUsers();
    }

    public String getNicknameByID(Long memberID) {
        return memberMapper.getNicknameByID(memberID);
    }
}
