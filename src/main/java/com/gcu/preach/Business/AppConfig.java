package com.gcu.preach.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class AppConfig {


    @Bean(name = "blogPostsBusinessService")
    BlogPostsBusinessService getBlogPostService() {
        return new BlogPostsBusinessService();
    }



    @Bean(name = "userBusinessService")
     UserBusinessServiceInterface getUserBusinessService() {
        return new UserBusinessService();
    }



}

