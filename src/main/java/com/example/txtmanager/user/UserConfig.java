package com.example.txtmanager.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repo){
        return args -> {
          User user = new User(
                  "kuba@gmail.com",
                  "kuba",
                  "pass"
          );

            repo.save(user);
        };
    }

}
