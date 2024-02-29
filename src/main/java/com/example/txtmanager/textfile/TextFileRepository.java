package com.example.txtmanager.textfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TextFileRepository extends JpaRepository<TextFile, UUID> {

    List<TextFile> findAllByOwnerId(UUID ownerId);

}
