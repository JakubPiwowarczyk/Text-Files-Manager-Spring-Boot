package com.example.txtmanager.textfile;

import com.example.txtmanager.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TextFileService {

    @Value("${file-database.path}")
    private String FILE_DATABASE_PATH;
    private final TextFileRepository fileRepository;

    @Autowired
    public TextFileService(TextFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public boolean createTextFile(TextFileDTO fileDTO) {
        String name = fileDTO.name();
        boolean isPrivate = fileDTO.isPrivate();
        User owner = fileDTO.owner();
        String content = fileDTO.content();

        TextFile file = new TextFile(name, isPrivate, owner);
        fileRepository.save(file);

        Path path = Path.of(FILE_DATABASE_PATH + "/" + file.getName());

        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            fileRepository.delete(file);
            return false;
        }

        return true;
    }
}
