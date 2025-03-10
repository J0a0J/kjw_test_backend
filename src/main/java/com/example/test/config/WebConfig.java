package com.example.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 경로에 대해
                .allowedOrigins("http://localhost:5173")  // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 메서드
                .allowedHeaders("*")  // 허용할 헤더
                .allowCredentials(true);
    }
}
