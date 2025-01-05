package com.example.communityplatformbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private Long memberId;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private Date joinDate;
    private String status;
}
