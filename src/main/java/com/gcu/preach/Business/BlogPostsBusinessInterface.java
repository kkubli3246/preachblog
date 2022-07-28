package com.gcu.preach.Business;

import com.gcu.preach.entity.BlogPost;

import java.util.List;

public interface BlogPostsBusinessInterface {
    List<BlogPost> createBlogPosts(BlogPost blogPost);
    List<BlogPost> getAllBlogPosts();

    void addBlogPost(BlogPost blogPost);


    int getSize();
}
