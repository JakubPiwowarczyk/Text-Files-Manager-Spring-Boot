package com.example.txtmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${file-database.path}")
    private String fileDatabasePath;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

        };
    }
}
