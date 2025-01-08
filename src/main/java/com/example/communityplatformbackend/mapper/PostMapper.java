package com.example.communityplatformbackend.mapper;

import com.example.communityplatformbackend.model.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostVO> getPostList();
}
