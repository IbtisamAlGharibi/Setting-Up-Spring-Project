package com.example.trainee_app;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    static List<InventoryBook> inventoryBookList = new ArrayList<>();
}
