package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Blog Management System API",
        version = "1.0.0",
        description = "Complete REST API for Blog Management with CRUD operations",
        contact = @Contact(
            name = "Rahul Mishra",
            email = "rm2778643@gmail.com"
        )
    )
)
public class BlogManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogManagementSystemApplication.class, args);
    }
}