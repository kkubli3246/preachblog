package com.gcu.preach.Business;


import com.gcu.preach.dao.BlogRepository;
import com.gcu.preach.entity.BlogPost;
import com.gcu.preach.model.BlogPostsList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BlogPostsBusinessService implements BlogPostsBusinessInterface {
public static List<BlogPost> blogPosts = new ArrayList<>();

    @Autowired
    private BlogRepository service;

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return service.getAllBlogPosts();
    }
    @Override
    public List<BlogPost> createBlogPosts(BlogPost blogPost) {
        service.createBlogPosts(blogPost);
        return service.getAllBlogPosts();
    }

    @Override
    public void addBlogPost(BlogPost blogPost) {
        blogPosts.add(blogPost);
    }

    @Override
    public int getNextBlogId() {
        return service.GetNextBlogPostId();
    }


}
