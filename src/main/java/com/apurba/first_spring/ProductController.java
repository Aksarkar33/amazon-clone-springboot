package com.apurba.first_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService service; // <--- Talk to the Manager, not the Repo!

    // 1. GET (Read)
    @GetMapping("/product")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    // 2. POST (Create)
    @PostMapping("/product")
    public Product addProduct(@Valid @RequestBody Product p) {
        return service.addProduct(p);
    }

    // 3. DELETE
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    // 4. PUT (Update)
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product p) {
        return service.updateProduct(id, p);
    }

    // 5. SEARCH
    @GetMapping("/product/search")
    public List<Product> search(@RequestParam String keyword) {
        return service.searchProducts(keyword);
    }
}