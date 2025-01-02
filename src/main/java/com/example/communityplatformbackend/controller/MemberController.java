package com.example.communityplatformbackend.controller;

import com.example.communityplatformbackend.model.MemberVO;
import com.example.communityplatformbackend.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;

    //모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVO> getAllMembers(@PathVariable("memberId")Long memberId) {
        Optional<MemberVO> memberVO = memberService.getMemberById(memberId);
        return new ResponseEntity<MemberVO>(memberVO.get(), HttpStatus.OK);
    }
}
