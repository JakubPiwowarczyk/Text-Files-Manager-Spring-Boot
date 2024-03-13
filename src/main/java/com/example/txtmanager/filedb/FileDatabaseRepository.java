package com.example.txtmanager.filedb;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Path;

@Repository
public interface FileDatabaseRepository {

    Path createUserDir(String username) throws IOException;


}
