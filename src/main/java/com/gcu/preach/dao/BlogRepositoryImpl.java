package com.gcu.preach.dao;

import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

    private static final String INSERT_BLOG_POST_QUERY = "INSERT INTO blogpost(id, title, contentPreview, fullContent, author, date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_BLOG_POST_BY_ID_QUERY = "SELECT * FROM blogpost WHERE id=?";
    private static final String GET_ALL_BLOG_POSTS_QUERY = "SELECT * FROM blogpost";
    private static final String GET_NEXT_BLOG_POST_ID_QUERY = "SELECT MAX(id) FROM blogpost";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean createBlogPosts(BlogPost blogPost) {
        jdbcTemplate.update(INSERT_BLOG_POST_QUERY, blogPost.getId(), blogPost.getTitle(),
                blogPost.getContentPreview(), blogPost.getFullContent(), blogPost.getAuthor(),
                blogPost.getDate());
        return true;
    }

    @Override
    public BlogPost getBlogPostById(int id) {
        return jdbcTemplate.queryForObject(GET_BLOG_POST_BY_ID_QUERY, (rs, rowNum) -> new BlogPost(
                rs.getInt("id"), rs.getString("title"),
                rs.getString("contentPreview"), rs.getString("fullContent"),
                rs.getString("author"), rs.getString("date")), id);
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return jdbcTemplate.query(GET_ALL_BLOG_POSTS_QUERY, (rs, rowNum) -> new BlogPost(
                rs.getInt("id"), rs.getString("title"),
                rs.getString("contentPreview"), rs.getString("fullContent"),
                rs.getString("author"), rs.getString("date")));
    }

    @Override
    public int GetNextBlogPostId() {
        return jdbcTemplate.queryForObject(GET_NEXT_BLOG_POST_ID_QUERY, Integer.class) + 1;
    }


}

