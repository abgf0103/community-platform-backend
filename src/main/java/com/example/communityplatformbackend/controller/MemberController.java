package com.example.communityplatformbackend.controller;

import com.example.communityplatformbackend.model.MemberVO;
import com.example.communityplatformbackend.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    private final JdbcTemplate jdbcTemplate;
//    public HelloWorldController(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

//    @GetMapping("/list")
//    public List<Map<String, Object>> getUsers(){
//        String sql = "SELECT * FROM MEMBER";
//        return jdbcTemplate.queryForList(sql);
//    }

    @GetMapping("/list2")
    public List<MemberVO> getUsers2() {
        return memberService.selectAllUsers();
    }

    @GetMapping("/getNickname")
    public ResponseEntity<String> getNickname(@RequestParam Long memberID) {
        String nickname = memberService.getNicknameByID(memberID);
        return ResponseEntity.ok(nickname);
    }
}
