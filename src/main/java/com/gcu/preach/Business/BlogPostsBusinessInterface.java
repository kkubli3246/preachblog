package com.gcu.preach.Business;

import com.gcu.preach.model.BlogPost;

import java.util.List;

public interface BlogPostsBusinessInterface {
    List<BlogPost> createBlogPosts();
    List<BlogPost> getAllBlogPosts();

    void addBlogPost(BlogPost blogPost);


    int getSize();
}
