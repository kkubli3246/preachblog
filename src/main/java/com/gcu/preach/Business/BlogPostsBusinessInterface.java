package com.gcu.preach.Business;

import com.gcu.preach.model.BlogPost;

import java.util.List;

public interface BlogPostsBusinessInterface {

     List<BlogPost> getAllBlogPosts();

     List<BlogPost> getMyBlogPosts(String username);




}
