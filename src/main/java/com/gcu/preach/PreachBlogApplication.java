package com.gcu.preach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.gcu" })
public class PreachBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreachBlogApplication.class, args);
	}

}
