package com.example.txtmanager.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void findByEmail_ShouldReturnUser_WhenUserExists() {
        // given
        String email = "john.doe@gmail.com";
        User user1 = new User(
                email,
                "JohnDoe",
                "johnny321"
        );
        User user2 = new User(
                "joe.biden@gmail.com",
                "JoeBiden",
                "white-house111"
        );
        userRepository.saveAll(List.of(user1, user2));

        // when
        User foundUser = userRepository.findByEmail(email).orElse(null);

        // then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser).isEqualTo(user1);
        assertThat(foundUser).isNotEqualTo(user2);
    }

    @Test
    public void findByEmail_ShouldReturnNull_WhenUserDoesNotExists() {
        // given
        String email = "john.doe@gmail.com";

        // when
        User foundUser = userRepository.findByEmail(email).orElse(null);

        // then
        assertThat(foundUser).isNull();
    }
}
