package com.gcu.preach.Business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostConfig {

    @Bean(name = "blogPostService")
    BlogPostsBusinessService getBlogPostService() {
        return new BlogPostsBusinessService();
    }

}

