package com.example.txtmanager.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repo){
        return args -> {
          User user1 = new User(
                  "kuba@gmail.com",
                  "kuba",
                  "pass"
          );
          User user2 = new User(
                  "maciek@gmail.com",
                  "maciek",
                  "pilka"
          );

            repo.saveAll(List.of(user1, user2));
        };
    }

}
