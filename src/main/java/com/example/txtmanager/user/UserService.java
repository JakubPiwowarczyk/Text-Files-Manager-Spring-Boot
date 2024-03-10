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
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
        User user = userMapper.toUser(userToRegister);
        userRepository.save(user);

        Path path = Path.of(FILE_DATABASE_PATH + "/" + user.getNickname());

        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            userRepository.delete(user);
            return false;
        }

        return true;
    }

}
