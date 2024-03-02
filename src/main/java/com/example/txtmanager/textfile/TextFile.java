package com.example.txtmanager.textfile;

import com.example.txtmanager.user.User;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class TextFile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String name;
    private boolean isPrivate;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User owner;

    public TextFile() {
    }

    public TextFile(UUID id, String name, boolean isPrivate, User owner) {
        this.id = id;
        this.name = owner.getNickname()+"/"+name;
        this.isPrivate = isPrivate;
        this.owner = owner;
    }

    public TextFile(String name, boolean isPrivate, User owner) {
        this.name = owner.getNickname()+"/"+name;
        this.isPrivate = isPrivate;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(id, textFile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPrivate=" + isPrivate +
                ", owner=" + owner.getNickname() +
                '}';
    }
}
