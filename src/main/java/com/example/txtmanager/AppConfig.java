package com.example.txtmanager;

import com.example.txtmanager.textfile.TextFile;
import com.example.txtmanager.textfile.TextFileRepository;
import com.example.txtmanager.user.User;
import com.example.txtmanager.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, TextFileRepository fileRepository){
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

            userRepository.saveAll(List.of(user1, user2));
            //System.out.println("test test "+userRepository.findById(user1.getId()).get().equals(user1));

            TextFile txt1 = new TextFile(
                    "myTxt",
                    false,
                    user1
            );

            TextFile txt2 = new TextFile(
                    "myTxt2",
                    false,
                    user1
            );

            fileRepository.saveAll(List.of(txt1, txt2));

            //System.out.println(fileRepository.findAllByOwnerId(user1.getId()));
           // System.out.println(fileRepository.findAllByOwnerId(user2.getId()));
        };
    }
}
