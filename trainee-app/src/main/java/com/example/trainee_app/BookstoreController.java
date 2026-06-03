package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    static List<InventoryBook> inventoryBookList = new ArrayList<>();

    @GetMapping("/addingBookToList")
    public String addingBookToList(@RequestParam int id, String title, double price, int stockCount){
        inventoryBookList.add(new InventoryBook(id,title,price,stockCount));
        return " Book is successfully added to the bookstore's catalog";
    }
}
