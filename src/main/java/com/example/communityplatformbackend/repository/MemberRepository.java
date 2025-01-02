package com.example.communityplatformbackend.repository;

import com.example.communityplatformbackend.model.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//extends JpaRepository<Member, Long>
public interface MemberRepository extends JpaRepository<MemberVO, Long> {

    public List<MemberVO> findByMemberId(Long memberId);

    public List<MemberVO> findByMemberName(String memberName);

    public List<MemberVO> findByNameLike(String nickname);
}
