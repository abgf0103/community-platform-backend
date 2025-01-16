package com.example.communityplatformbackend.controller;

import com.example.communityplatformbackend.model.JwtResponse;
import com.example.communityplatformbackend.model.UserVO;
import com.example.communityplatformbackend.service.JwtTokenProvider;
import com.example.communityplatformbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

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
    public List<UserVO> getUsers2() {
        return userService.selectAllUsers();
    }

    @GetMapping("/getNickname")
    public ResponseEntity<String> getNickname(@RequestParam Long memberID) {
        String nickname = userService.getNicknameByID(memberID);
        return ResponseEntity.ok(nickname);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserVO userVO) {
        log.info("Login user: {}", userVO);
        if(userService.loginUser(userVO)){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userVO.getUsername(), userVO.getPassword())
            );

            String token = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtResponse(token));
        }else{
            return ResponseEntity.ok("Invalid username or password");
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserVO userVO) throws UnsupportedEncodingException {
        userService.signUpUser(userVO);
        return ResponseEntity.ok("회원가입 성공");
    }
}
