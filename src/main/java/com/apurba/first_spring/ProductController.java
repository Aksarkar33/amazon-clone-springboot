package com.apurba.first_spring;

import org.springframework.web.bind.annotation.*; // Imports everything (Get, Post, Delete, Body, etc.)
import java.util.List;

import jakarta.validation.Valid;


@RestController
public class ProductController {

    private final ProductRepository repo;

    // Constructor Injection
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // 1. GET Request: "Show me all products"
    // URL: http://localhost:8080/product
    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    // 5. SEARCH Request
    // URL: http://localhost:8080/product/search?keyword=Phone
    @GetMapping("/product/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return repo.findByNameContaining(keyword);
    }
    // 2. POST Request: "Add a new product"
    // URL: http://localhost:8080/product
    @PostMapping("/product")
    public Product addProduct(@Valid @RequestBody Product newProduct) {
        return repo.save(newProduct);
    }

    // 3. DELETE Request: "Remove product by ID"
    // URL: http://localhost:8080/product/{id}
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
        return "Product " + id + " Deleted Successfully! 🗑️";
    }

    @PutMapping("product/{id}")
    public Product updateProduct(@PathVariable Long id,@Valid @RequestBody Product product) {
        //TODO: process PUT request
        
         product.setId(id);
         return repo.save(product);
    }
}