package com.gcu.preach.Business;

import com.gcu.preach.entity.BlogPost;

import java.util.List;

public interface BlogPostsBusinessInterface {
    void createBlogPosts(BlogPost blogPost);
    List<BlogPost> getAllBlogPosts();
    void addBlogPost(BlogPost blogPost);
    int getNextBlogId();

    void createUserBlogPosts(BlogPost blogPost);
    List<BlogPost> getAllUserBlogPosts();
    void addUserBlogPost(BlogPost blogPost);
    int getNextUserBlogId();
}
