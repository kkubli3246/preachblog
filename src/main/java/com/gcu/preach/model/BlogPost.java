package com.gcu.preach.model;

public class BlogPost {

    private int id;
    private String title;
    private String contentPreview;
    private String fullContent;
    private String author;
    private String date;

    public BlogPost(int id, String title, String contentPreview, String fullContent, String author, String date) {
        this.id = id;
        this.title = title;
        this.contentPreview = contentPreview;
        this.fullContent = fullContent;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentPreview() {
        return contentPreview;
    }

    public void setContentPreview(String contentPreview) {
        this.contentPreview = contentPreview;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
