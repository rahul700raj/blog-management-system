package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    
    @Autowired
    private BlogRepository blogRepository;
    
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
    
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }
    
    public List<Blog> getPublishedBlogs() {
        return blogRepository.findByPublished(true);
    }
    
    public List<Blog> searchByTitle(String title) {
        return blogRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<Blog> searchByAuthor(String author) {
        return blogRepository.findByAuthorContainingIgnoreCase(author);
    }
    
    public List<Blog> searchByCategory(String category) {
        return blogRepository.findByCategoryContainingIgnoreCase(category);
    }
    
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }
    
    public Blog updateBlog(Long id, Blog blogDetails) {
        Blog blog = blogRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
        
        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        blog.setAuthor(blogDetails.getAuthor());
        blog.setCategory(blogDetails.getCategory());
        blog.setTags(blogDetails.getTags());
        blog.setPublished(blogDetails.getPublished());
        
        return blogRepository.save(blog);
    }
    
    public void deleteBlog(Long id) {
        Blog blog = blogRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
        blogRepository.delete(blog);
    }
    
    public void deleteAllBlogs() {
        blogRepository.deleteAll();
    }
}