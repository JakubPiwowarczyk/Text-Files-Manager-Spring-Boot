package com.example.txtmanager.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserRegisterDTO registerDTO) {
        String email = registerDTO.email();
        String nickname = registerDTO.nickname();
        String password = registerDTO.password();

        return new User(email, nickname, password);
    }

}
