package com.example.txtmanager.textfile;

import org.springframework.stereotype.Service;

import com.example.txtmanager.user.User;

@Service
public class TextFileMapper {

    public TextFile toTextFile(TextFileDTO textFileDTO) {
        String name = textFileDTO.name();
        boolean isPrivate = textFileDTO.isPrivate();
        User owner = textFileDTO.owner();

        return new TextFile(name, isPrivate, owner);
    }

}
