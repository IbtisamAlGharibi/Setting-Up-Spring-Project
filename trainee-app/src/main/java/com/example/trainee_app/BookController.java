package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/find-by-id")
    public Book findById(@RequestParam int id){
       for (int i =0; i<books.size();i++){
           Book book = books.get(i);
           if ( book.getId() == id){
               return book;
           }
       }
       return null;
    }

    @GetMapping("/find-by-name")
    public String findByName( @RequestParam String name){
        for (int i =0; i<books.size();i++){
            Book book = books.get(i);
            if ( book.getName().equalsIgnoreCase(name)){
                return name;
            }
        }
        return null;
    }

    @GetMapping("/search-msg")
    public String searchMessage(int id, String name){
        for (int i =0; i<books.size();i++){
            Book book = books.get(i);
            if ( book.getId() == id){
                return "Found: " + book.getName();
            }
        }
        return "Sorry, that book ID is not available.";
    }
}
