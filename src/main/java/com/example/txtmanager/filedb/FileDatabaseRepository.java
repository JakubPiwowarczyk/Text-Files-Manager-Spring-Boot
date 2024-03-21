package com.example.txtmanager.filedb;

import org.springframework.stereotype.Repository;

import com.example.txtmanager.textfile.TextFileDTO;

import java.io.IOException;
import java.nio.file.Path;

@Repository
public interface FileDatabaseRepository {

    Path createUserDir(String username) throws IOException;

    Path findDirByUsername(String username);

    Path createFile(TextFileDTO fileDTO) throws IOException;
}
