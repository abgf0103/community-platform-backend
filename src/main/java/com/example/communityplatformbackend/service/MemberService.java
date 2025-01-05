package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.mapper.MemberMapper;
import com.example.communityplatformbackend.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberVO> getAllMembers() {
        return memberMapper.getAllMember();
    }
}
