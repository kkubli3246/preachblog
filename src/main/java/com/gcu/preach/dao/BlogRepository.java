package com.gcu.preach.dao;


import com.gcu.preach.entity.BlogPost;

import java.util.List;

public interface BlogRepository {
    boolean createBlogPosts(BlogPost blogPost);
    BlogPost getBlogPostById(int id);
    List<BlogPost> getAllBlogPosts();
}
