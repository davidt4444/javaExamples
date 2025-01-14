package com.bcs.app.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Size(min = 5, max = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(max = 10000)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "author", length = 200)
    private String author;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "likes_count", nullable = false)
    private Integer likesCount;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished;

    @Column(name = "views", nullable = false)
    private Integer views;

    // Constructors
    public BlogPost() {
        this.createdAt = LocalDateTime.now();
        this.likesCount = 0;
        this.isPublished = false;
        this.views = 0;
    }

    // Constructor for creating a new blog post
    public BlogPost(String title, String content, String author, String category) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.createdAt = LocalDateTime.now();
        this.likesCount = 0;
        this.isPublished = false;
        this.views = 0;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    // This method can be called before persisting to update the 'updatedAt' field
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}