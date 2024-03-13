package com.example.txtmanager.filedb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FileDatabaseRepositoryImpl implements FileDatabaseRepository{

    @Value("${file-database.path}")
    private static String FILE_DATABASE_PATH;

    @Override
    public Path createUserDir(String username) throws IOException {
        Path path = Path.of(FILE_DATABASE_PATH + "/" + username);
        return Files.createDirectory(path);
    }

}
