package com.example.txtmanager.user;

import com.example.txtmanager.filedb.FileDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final FileDatabaseRepository fileDatabaseRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       FileDatabaseRepository fileDatabaseRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.fileDatabaseRepository = fileDatabaseRepository;
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

    public boolean registerUser(UserRegisterDTO userToRegister) throws IOException {
        User user = userMapper.toUser(userToRegister);
        userRepository.save(user);

        fileDatabaseRepository.createUserDir(user.getNickname());

        return true;
    }

}
