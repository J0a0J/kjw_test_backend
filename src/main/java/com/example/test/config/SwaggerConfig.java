package com.example.test.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig implements SwaggerConfigInterface {

    @Bean
    public GroupedOpenApi boardGroupedOpenApi() {
        return createGroupedOpenApi("board", "/board/**", "Board API", "게시판 기능 처리를 위한 API");
    }

    @Bean
    public GroupedOpenApi commentGroupedOpenApi() {
        return createGroupedOpenApi("comment", "/comment/**", "Comment API", "댓글 기능 처리를 위한 API");
    }
}
