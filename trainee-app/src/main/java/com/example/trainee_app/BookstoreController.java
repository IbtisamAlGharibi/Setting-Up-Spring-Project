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

    @GetMapping("/checkStock")
    public String checkStock(@RequestParam int targetId){

       for (InventoryBook inventoryBook: inventoryBookList) {
           if (inventoryBook.getBookId() == targetId) {
               if (inventoryBook.getStockCount() > 0) {
                   return "Book is Available: " + inventoryBook.getTitle()
                           + ", Price: " + inventoryBook.getPrice();
               } else {
                   return "Sorry, this book is sold out.";
               }
           }
       }
       return "The Book store doesn't contain this book";
    }

    @GetMapping("/lowStockReport")
    public String lowStockReport(@RequestParam int stockThreshold){
        String report = "";
        for (InventoryBook inventoryBook : inventoryBookList){

            if (inventoryBook.getStockCount() <= stockThreshold){
                report += "Title: " + inventoryBook.getTitle()
                        + ", Stock Count: " + inventoryBook.getStockCount();
            }
        }
        if (report.equals("")){
            return "There is No Books!";
        }

        return report;
    }
}
