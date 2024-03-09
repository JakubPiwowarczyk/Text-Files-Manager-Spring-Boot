package com.example.txtmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Value("${file-database.path}")
    private String FILE_DATABASE_PATH;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public boolean isEmailInUse(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean isNicknameInUse(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    public boolean registerUser(UserRegisterDTO userToRegister) {
        String email = userToRegister.email();
        String nickname = userToRegister.nickname();
        String password = userToRegister.password();

        User user = new User(email, nickname, password);

        try {
            Files.createDirectory(Path.of(FILE_DATABASE_PATH + "/" + nickname));
        } catch (IOException e) {
            return false;
        }

        userRepository.save(user);
        return true;
    }

}
