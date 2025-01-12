package com.bcs.app.controller;

import com.bcs.app.model.BlogPost;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/blogPosts")
public class BlogPostController {

    private Map<Long, BlogPost> blogPosts = new HashMap<>();

    @GetMapping
    @Operation(summary = "Get all blog posts", description = "Retrieve all blog posts from the system.")
    public List<BlogPost> getAllBlogPosts() {
        return new ArrayList<>(blogPosts.values());
    }

    @PostMapping
    @Operation(summary = "Add a new blog post", description = "Add a new blog post to the system.")
    @ApiResponse(responseCode = "201", description = "Blog post created", content = @Content(schema = @Schema(implementation = BlogPost.class)))
    public ResponseEntity<BlogPost> addBlogPost(@RequestBody BlogPost blogPost) {
        Long id = blogPosts.size() + 1L;
        blogPost.setId(id);
        blogPosts.put(id, blogPost);
        return ResponseEntity.status(201).body(blogPost);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find blog post by ID", description = "Retrieve a specific blog post by its ID.")
    @ApiResponse(responseCode = "200", description = "Blog post found", content = @Content(schema = @Schema(implementation = BlogPost.class)))
    @ApiResponse(responseCode = "404", description = "Blog post not found")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPosts.get(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blogPost);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update blog post", description = "Update an existing blog post by ID.")
    @ApiResponse(responseCode = "200", description = "Blog post updated", content = @Content(schema = @Schema(implementation = BlogPost.class)))
    @ApiResponse(responseCode = "404", description = "Blog post not found")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPostDetails) {
        BlogPost blogPost = blogPosts.get(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        blogPost.setTitle(blogPostDetails.getTitle());
        blogPost.setContent(blogPostDetails.getContent());
        return ResponseEntity.ok(blogPost);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete blog post", description = "Delete a blog post by ID.")
    @ApiResponse(responseCode = "204", description = "Blog post deleted")
    @ApiResponse(responseCode = "404", description = "Blog post not found")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        BlogPost blogPost = blogPosts.remove(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}