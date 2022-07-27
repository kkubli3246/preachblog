package com.gcu.preach.Business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




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

