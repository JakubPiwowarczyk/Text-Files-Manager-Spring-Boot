package com.example.txtmanager.textfile;

import com.example.txtmanager.user.User;
import com.example.txtmanager.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TextFileRepositoryTest {

    @Autowired
    private TextFileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        fileRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void findAllByOwnerId_ShouldReturnListOfTextFilesOwnedByUser() {
        // given
        User user = new User(
                "john.doe@gmail.com",
                "JohnDoe",
                "johnny321"
        );
        userRepository.save(user);

        TextFile file1 = new TextFile(
                "my-txt1",
                false,
                user
        );
        TextFile file2 = new TextFile(
                "my-txt2",
                false,
                user
        );

        List<TextFile> fileList = List.of(file1, file2);
        fileRepository.saveAll(fileList);

        // when
        List<TextFile> returnedList = fileRepository.findAllByOwnerId(user.getId());

        // then
        assertThat(returnedList).isEqualTo(fileList);
    }
}