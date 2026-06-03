package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    private static List<Author> authorList = new ArrayList<>();
    private static List<Book> bookList =new ArrayList<>();

    @GetMapping("/addAuthor")
    public String addAuthor(int id, String name, String biography){
        authorList.add(new Author(id,name,biography));
        return "Author added successfully";
    }

    @GetMapping("/allAuthors")
    public List<Author> allAuthors(){
        return authorList;
    }

    @GetMapping("/addRelationalBook")
    public String addRelationalBook(@RequestParam int id, String name, int authorId){
        boolean authorExists = false;
        for (Author author : authorList) {
            if (author.getId() == authorId) {
                authorExists = true;
                break;
            }
            if (authorExists) {
                bookList.add(new Book(id, name, authorId));
                return "Book added successfully";
            }
        }
        return "Error: Registry Failed";
    }
}
