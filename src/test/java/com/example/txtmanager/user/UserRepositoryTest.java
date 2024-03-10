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
    UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void findByEmail_ShouldReturnUser_WhenUserExists() {
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
    void findByEmail_ShouldReturnEmptyOptional_WhenUserDoesNotExists() {
        // given
        String email = "john.doe@gmail.com";

        // when
        boolean wasUserFound = userRepository.findByEmail(email).isPresent();

        // then
        assertThat(wasUserFound).isFalse();
    }

    @Test
    void findByNickname_ShouldReturnUser_WhenUserExists() {
        // given
        String nickname = "JohnDoe";
        User user1 = new User(
                "john.doe@gmail.com",
                nickname,
                "johnny321"
        );
        User user2 = new User(
                "joe.biden@gmail.com",
                "JoeBiden",
                "white-house111"
        );
        userRepository.saveAll(List.of(user1, user2));

        // when
        User foundUser = userRepository.findByNickname(nickname).orElse(null);

        // then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser).isEqualTo(user1);
        assertThat(foundUser).isNotEqualTo(user2);
    }

    @Test
    void findByNickname_ShouldReturnEmptyOptional_WhenUserDoesNotExists() {
        // given
        String nickname = "JohnDoe";

        // when
        boolean wasUserFound = userRepository.findByNickname(nickname).isPresent();

        // then
        assertThat(wasUserFound).isFalse();
    }

    @Test
    void existsByEmail_ShouldReturnTrue_WhenUserExists() {
        // given
        String email = "john.doe@gmail.com";
        User user = new User(
                email,
                "JohnDoe",
                "johnny321"
        );
        userRepository.save(user);

        // when
        boolean doesUserExists = userRepository.existsByEmail(email);

        // then
        assertThat(doesUserExists).isTrue();
    }

    @Test
    void existsByEmail_ShouldReturnFalse_WhenUserDoesNotExists() {
        // given
        String email = "john.doe@gmail.com";

        // when
        boolean doesUserExists = userRepository.existsByEmail(email);

        // then
        assertThat(doesUserExists).isFalse();
    }

    @Test
    void existsByNickname_ShouldReturnTrue_WhenUserExists() {
        // given
        String nickname = "JohnDoe";
        User user = new User(
                "john.doe@gmail.com",
                nickname,
                "johnny321"
        );
        userRepository.save(user);

        // when
        boolean doesUserExists = userRepository.existsByNickname(nickname);

        // then
        assertThat(doesUserExists).isTrue();
    }

    @Test
    void existsByNickname_ShouldReturnFalse_WhenUserDoesNotExists() {
        // given
        String nickname = "JohnDoe";

        // when
        boolean doesUserExists = userRepository.existsByNickname(nickname);

        // then
        assertThat(doesUserExists).isFalse();
    }
}
