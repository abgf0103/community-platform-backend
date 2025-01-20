package com.example.communityplatformbackend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    private LocalDateTime joinDate;  // 자동으로 DB에서 설정

    @Column(nullable = false)  // DB에서 기본값 처리되므로 JPA에서 처리하지 않음
    private String status;

    // 기본 생성자와 생성자를 통한 값 설정
    public UserEntity() {}

    public UserEntity(String email, String username, String nickname, String password) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }
}
