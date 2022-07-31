package com.gcu.preach.dao;


import com.gcu.preach.entity.BlogPost;

import java.util.List;

public interface UserBlogRepository {
    void createUserBlogPosts(BlogPost blogPost);
    BlogPost getUserBlogPostById(int id);
    List<BlogPost> getAllUserBlogPosts(String username);

    int GetNextUserBlogPostId();
}
