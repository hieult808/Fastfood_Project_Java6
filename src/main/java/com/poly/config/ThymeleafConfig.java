package com.poly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poly.util.CustomNumberFormat;

@Configuration
public class ThymeleafConfig {

    @Bean
    public CustomNumberFormat customNumberFormat() {
        return new CustomNumberFormat();
    }

    // Các cấu hình khác cho Thymeleaf
    // ...
}

