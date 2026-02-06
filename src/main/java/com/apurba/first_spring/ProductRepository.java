package com.apurba.first_spring;

import java.util.List; // <--- This import is crucial
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // This is the line your Service is looking for! 👇
    List<Product> findByNameContaining(String keyword);
}