package com.example.communityplatformbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 요청 경로에 대해 CORS 허용
        registry.addMapping("/**")  // 모든 API 경로에 대해 허용
                .allowedOrigins("http://localhost:3000")  // React 앱의 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드
                .allowedHeaders("*");  // 모든 헤더를 허용
    }
}