package com.example.communityplatformbackend;

import jakarta.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackageClasses = {
        CommunityPlatformBackendApplication.class,
        Jsr310JpaConverters.class
})
@MapperScan(basePackages = "com.example.communityplatformbackend.mapper")
public class CommunityPlatformBackendApplication {
    @Value("${uploadPath}")
    private String uploadPath;

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication.run(CommunityPlatformBackendApplication.class, args);
    }

    @Bean(name = "uploadPath")
    public String uploadPath() {
        return uploadPath;
    }
}
