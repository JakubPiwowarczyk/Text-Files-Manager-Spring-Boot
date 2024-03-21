package com.example.txtmanager.textfile;

import com.example.txtmanager.filedb.FileDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TextFileService {

    private final TextFileRepository fileRepository;
    private final FileDatabaseRepository fileDatabaseRepository;
    private final TextFileMapper fileMapper;

    @Autowired
    public TextFileService(TextFileRepository fileRepository,
                            FileDatabaseRepository fileDatabaseRepository,
                            TextFileMapper fileMapper) {
        this.fileRepository = fileRepository;
        this.fileDatabaseRepository = fileDatabaseRepository;
        this.fileMapper = fileMapper;
    }

    public boolean createTextFile(TextFileDTO fileDTO) throws IOException {
        TextFile textFile = fileMapper.toTextFile(fileDTO);
        fileRepository.save(textFile);

        fileDatabaseRepository.createFile(fileDTO);

        //TODO should return TextFileDto based on created textfile 
        return true;
    }
}
