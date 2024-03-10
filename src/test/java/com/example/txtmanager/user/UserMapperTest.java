package com.example.txtmanager.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void toUser_ShouldMapUserRegisterDTOToUser() {
        // given
        String email = "john.doe@gmail.com";
        String nickname = "JohnDoe";
        String password = "johnny321";

        // when
        User returnedUser = userMapper.toUser(
                new UserRegisterDTO(email, nickname, password)
        );

        // then
        assertThat(returnedUser.getEmail()).isEqualTo(email);
        assertThat(returnedUser.getNickname()).isEqualTo(nickname);
        assertThat(returnedUser.getPassword()).isEqualTo(password);
    }

}