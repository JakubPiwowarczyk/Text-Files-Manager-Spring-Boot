package com.example.txtmanager.textfile;

import com.example.txtmanager.user.User;

public record TextFileDTO(String name, boolean isPrivate, User owner, String content) {
}
