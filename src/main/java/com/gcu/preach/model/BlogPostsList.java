package com.gcu.preach.model;


import java.util.ArrayList;
import java.util.List;

public class BlogPostsList {
    private List<BlogPost> blogPostsList = new ArrayList<>();

    public List<BlogPost> getAllBlogPosts() {
        return this.blogPostsList;
    }

    public void setBlogPostsList(List<BlogPost> blogPostsList) {
        this.blogPostsList = blogPostsList;
    }
}
