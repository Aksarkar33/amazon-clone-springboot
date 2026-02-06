package com.apurba.first_spring;

import java.util.List; // <--- Make sure this is imported!
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // MAGIC METHOD: Spring sees "ByNameContaining" and automatically
    // writes the SQL: SELECT * FROM Product WHERE name LIKE '%keyword%'
    List<Product> findByNameContaining(String keyword);

}