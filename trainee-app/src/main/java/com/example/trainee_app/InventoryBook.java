package com.example.trainee_app;

public class InventoryBook {
    int bookId;
    String title;
    double price;
    int stockCount;

    public InventoryBook(int bookId, String title, double price, int stockCount) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.stockCount = stockCount;
    }
}
