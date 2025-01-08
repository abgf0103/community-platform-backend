package com.example.communityplatformbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostVO {
    private Long postID;
    private String title;
    private String content;
    private String authorID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long likes;
    private Long dislikes;
    private String status;
}
