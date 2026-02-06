package com.apurba.first_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void testServiceIsRunning() {
        // 1. Ask the Service: "Are you there?"
        // 2. If service is null, the test FAILS.
        assertNotNull(service, "The Service should not be null");
        
        System.out.println("✅ TEST PASSED: Service is loaded and ready!");
    }
}