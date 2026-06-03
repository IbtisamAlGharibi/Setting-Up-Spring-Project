package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    static private ArrayList<Book> books = new ArrayList<>();

    @GetMapping("/add-book")
    public String add(int id, String name){
     books.add(new Book(id,name));
     return  "Book added successfully!";
    }

    @GetMapping("/all-books")
    public List<Book> AllBooks(){
        return books;
    }
}
