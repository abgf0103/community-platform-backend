package com.example.communityplatformbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserVO {
    private Long userID;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private Date joinDate;
    private String status;
}
