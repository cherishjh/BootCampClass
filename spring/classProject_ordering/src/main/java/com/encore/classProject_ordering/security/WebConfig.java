package com.encore.classProject_ordering.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
//                .allowedOrigins("http://localhost:8081")        //vue url
                .allowedOrigins("https://www.vlffkepfvldk.store")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
