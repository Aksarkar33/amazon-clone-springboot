package com.apurba.first_spring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // <--- vital! This tells Spring: "This is a Service Component"
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // 1. Get All
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // 2. Add Product
    public Product addProduct(Product p) {
        return repo.save(p);
    }

    // 3. Search
    public List<Product> searchProducts(String keyword) {
        return repo.findByNameContaining(keyword);
    }

    // 4. Update Product
    public Product updateProduct(Long id, Product p) {
        p.setId(id); // Ensure the ID is set
        return repo.save(p);
    }

    // 5. Delete Product
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}