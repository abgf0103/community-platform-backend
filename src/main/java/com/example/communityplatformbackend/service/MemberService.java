package com.example.communityplatformbackend.service;

import com.example.communityplatformbackend.model.MemberVO;
import com.example.communityplatformbackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVO> getAllMembers() {
        List<MemberVO> members = new ArrayList<>();
        memberRepository.findAll().forEach(members::add);
        return members;
    }

    public Optional<MemberVO> getMemberById(Long memberId) {
        Optional<MemberVO> member = memberRepository.findById(memberId);
        return member;
    }

    public void deleteMemberById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public MemberVO save(MemberVO memberVO) {
        memberRepository.save(memberVO);
        return memberVO;
    }

    public void updateMember(Long memberId, MemberVO memberVO) {
        Optional<MemberVO> e = memberRepository.findById(memberId);

        if (e.isPresent()) {
            e.get().setMemberId(memberVO.getMemberId());
            e.get().setUsername(memberVO.getUsername());
            e.get().setPassword(memberVO.getPassword());
            e.get().setNickname(memberVO.getNickname());
            e.get().setUpdateTime(memberVO.getUpdateTime());
            memberRepository.save(memberVO);
        }
    }
}
