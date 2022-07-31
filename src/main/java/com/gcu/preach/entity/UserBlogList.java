package com.gcu.preach.entity;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserBlogList {

    private List<BlogPost> userBlogPosts;

}
