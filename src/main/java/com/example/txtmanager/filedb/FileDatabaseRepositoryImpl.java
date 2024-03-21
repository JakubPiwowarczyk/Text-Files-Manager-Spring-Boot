package com.example.txtmanager.filedb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.txtmanager.textfile.TextFileDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FileDatabaseRepositoryImpl implements FileDatabaseRepository{

    @Value("${file-database.path}")
    private static String FILE_DATABASE_PATH;

    @Override
    public Path createUserDir(String username) throws IOException {
        String path = FILE_DATABASE_PATH + "/" + username;
        return Files.createDirectory(Path.of(path));
    }

    @Override
    public Path findDirByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findDirByUsername'");
    }

    @Override
    public Path createFile(TextFileDTO fileDTO) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createFile'");
    }    
}
