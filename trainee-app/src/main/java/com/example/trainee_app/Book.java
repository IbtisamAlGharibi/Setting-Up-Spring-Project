package com.example.trainee_app;

public class Book {
    int id;
    String name;
    int authorId;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(int authorId) {
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
