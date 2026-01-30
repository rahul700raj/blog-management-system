package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@Tag(name = "Blog Management", description = "APIs for managing blog posts")
@CrossOrigin(origins = "*")
public class BlogController {
    
    @Autowired
    private BlogService blogService;
    
    @GetMapping
    @Operation(summary = "Get all blogs", description = "Retrieve all blog posts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get blog by ID", description = "Retrieve a specific blog post by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog found"),
        @ApiResponse(responseCode = "404", description = "Blog not found")
    })
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id)
            .map(blog -> new ResponseEntity<>(blog, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/published")
    @Operation(summary = "Get published blogs", description = "Retrieve all published blog posts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved published blogs")
    public ResponseEntity<List<Blog>> getPublishedBlogs() {
        List<Blog> blogs = blogService.getPublishedBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    
    @GetMapping("/search/title")
    @Operation(summary = "Search blogs by title", description = "Search blog posts by title keyword")
    @ApiResponse(responseCode = "200", description = "Search completed successfully")
    public ResponseEntity<List<Blog>> searchByTitle(@RequestParam String title) {
        List<Blog> blogs = blogService.searchByTitle(title);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    
    @GetMapping("/search/author")
    @Operation(summary = "Search blogs by author", description = "Search blog posts by author name")
    @ApiResponse(responseCode = "200", description = "Search completed successfully")
    public ResponseEntity<List<Blog>> searchByAuthor(@RequestParam String author) {
        List<Blog> blogs = blogService.searchByAuthor(author);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    
    @GetMapping("/search/category")
    @Operation(summary = "Search blogs by category", description = "Search blog posts by category")
    @ApiResponse(responseCode = "200", description = "Search completed successfully")
    public ResponseEntity<List<Blog>> searchByCategory(@RequestParam String category) {
        List<Blog> blogs = blogService.searchByCategory(category);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    
    @PostMapping
    @Operation(summary = "Create new blog", description = "Create a new blog post")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Blog created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Blog> createBlog(@Valid @RequestBody Blog blog) {
        Blog createdBlog = blogService.createBlog(blog);
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update blog", description = "Update an existing blog post")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog updated successfully"),
        @ApiResponse(responseCode = "404", description = "Blog not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @Valid @RequestBody Blog blog) {
        try {
            Blog updatedBlog = blogService.updateBlog(id, blog);
            return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete blog", description = "Delete a blog post by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Blog deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Blog not found")
    })
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        try {
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping
    @Operation(summary = "Delete all blogs", description = "Delete all blog posts")
    @ApiResponse(responseCode = "204", description = "All blogs deleted successfully")
    public ResponseEntity<Void> deleteAllBlogs() {
        blogService.deleteAllBlogs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}