package com.gcu.preach.entity;

import lombok.*;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserBlogList {

	
	private List<BlogPost> userBlogPosts;

}
