package com.example.txtmanager.textfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextFileService {

    private final TextFileRepository fileRepository;

    @Autowired
    public TextFileService(TextFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


}
