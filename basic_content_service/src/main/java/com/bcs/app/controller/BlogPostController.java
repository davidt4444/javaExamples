package com.bcs.app.controller;

import com.bcs.app.model.BlogPost;
import com.bcs.app.repository.BlogPostRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping
    @Operation(summary = "Get all blog posts", description = "Retrieve all blog posts from the database.")
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Add a new blog post", description = "Add a new blog post to the database.")
    @ApiResponse(responseCode = "201", description = "Blog post created", content = @Content(schema = @Schema(implementation = BlogPost.class)))
    public ResponseEntity<BlogPost> addBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost savedBlogPost = blogPostRepository.save(blogPost);
        return ResponseEntity.status(201).body(savedBlogPost);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find blog post by ID", description = "Retrieve a specific blog post by its ID from the database.")
    @ApiResponse(responseCode = "200", description = "Blog post found", content = @Content(schema = @Schema(implementation = BlogPost.class)))
    @ApiResponse(responseCode = "404", description = "Blog post not found")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Integer id) {
        return blogPostRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update blog post", description = "Update an existing blog post by ID in the database.")
    @ApiResponse(responseCode = "200", description = "Blog post updated", content = @Content(schema = @Schema(implementation = BlogPost.class)))
    @ApiResponse(responseCode = "404", description = "Blog post not found")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Integer id, @RequestBody BlogPost blogPostDetails) {
        return blogPostRepository.findById(id).map(existingBlogPost -> {
            existingBlogPost.setTitle(blogPostDetails.getTitle());
            existingBlogPost.setContent(blogPostDetails.getContent());
            BlogPost updatedBlogPost = blogPostRepository.save(existingBlogPost);
            return ResponseEntity.ok(updatedBlogPost);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete blog post", description = "Delete a blog post by ID from the database.")
    @ApiResponse(responseCode = "204", description = "Blog post deleted")
    @ApiResponse(responseCode = "404", description = "Blog post not found")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Integer id) {
        if (blogPostRepository.existsById(id)) {
            blogPostRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}