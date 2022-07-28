package com.gcu.preach.model;

import com.gcu.preach.entity.BlogPost;

import java.util.List;

public class UserBlogPostList {
    private List<BlogPost> userBlogPostList;

    public UserBlogPostList() {

    }

    public List<BlogPost> getUserBlogPostList() {
        return userBlogPostList;
    }

    public void setUserBlogPostList(List<BlogPost> userBlogPostList) {
        this.userBlogPostList = userBlogPostList;
    }

}
