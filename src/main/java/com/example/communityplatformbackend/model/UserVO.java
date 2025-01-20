package com.example.communityplatformbackend.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long userID;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private LocalDateTime joinDate;
    private String status;
}
