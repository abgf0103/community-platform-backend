package com.example.communityplatformbackend.controller;

import com.example.communityplatformbackend.model.MemberVO;
import com.example.communityplatformbackend.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/getAllMember")
    public ResponseEntity<?> memberList(@ModelAttribute MemberVO memberVO) {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping
    public List<MemberVO> getAllMembers() {
        return memberService.getAllMembers();
    }
}
