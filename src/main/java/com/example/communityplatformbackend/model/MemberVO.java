package com.example.communityplatformbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "member")
public class MemberVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private Date createTime;
    private Date updateTime;

    @Builder
    public MemberVO(Long memberId, String username, String password, String email, String nickname, Date createTime, Date updateTime) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
