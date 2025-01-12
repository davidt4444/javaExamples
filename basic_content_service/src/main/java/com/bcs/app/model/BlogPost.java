package com.bcs.app.model;

public class BlogPost {
    private Long id;
    private String title;
    private String content;

    // Constructors, Getters, and Setters
    public BlogPost() {}

    public BlogPost(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}