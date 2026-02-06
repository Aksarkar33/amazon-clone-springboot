package com.apurba.first_spring;

import org.springframework.boot.CommandLineRunner; // <--- NEW IMPORT
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean; // <--- NEW IMPORT

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

    // --- NEW CODE STARTS HERE ---
    
   // @Bean
    // public CommandLineRunner demo(ProductRepository repo) {
    //     return (args) -> {
            
    //         // 1. Create a Product
    //         Product p1 = new Product();
    //         p1.setName("iPhone 15");
    //         p1.setPrice(75000.00);

    //         // 2. Save it to Database (The Magic Line)
    //         repo.save(p1);

    //         System.out.println(" SUCCESS! iPhone saved to Database!");
    //     };
    // }
    // --- NEW CODE ENDS HERE ---

}