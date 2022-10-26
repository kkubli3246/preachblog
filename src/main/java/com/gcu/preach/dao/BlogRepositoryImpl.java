package com.gcu.preach.dao;

import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository, UserBlogRepository {

	// User Blog Posts
	private static final String INSERT_USER_BLOG_POST_QUERY = "INSERT INTO UserBlogPost(id, title, contentPreview, fullContent, author, date, likes) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_USER_BLOG_POST_BY_ID_QUERY = "SELECT * FROM UserBlogPost WHERE id=?";
	private static final String GET_ALL_USER_BLOG_POSTS_QUERY = "SELECT * FROM UserBlogPost WHERE author=?";
	private static final String GET_NEXT_USER_BLOG_POST_ID_QUERY = "SELECT MAX(id) FROM UserBlogPost";
	private static final String UPDATE_USER_BLOG_POST_BY_ID_QUERY = "UPDATE UserBlogPost SET title=?, contentPreview=?, fullContent=?, author=?, date=?, likes=? WHERE id=?";
	private static final String DELETE_USER_BLOG_POST_BY_ID_QUERY = "DELETE FROM UserBlogPost WHERE id=?";

	// All Blog Posts
	private static final String INSERT_BLOG_POST_QUERY = "INSERT INTO BlogPost(id, title, contentpreview, fullcontent, author, date, likes) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_BLOG_POST_BY_ID_QUERY = "SELECT * FROM BlogPost WHERE id=?";
	private static final String GET_ALL_BLOG_POSTS_QUERY = "SELECT * FROM BlogPost";
	private static final String GET_NEXT_BLOG_POST_ID_QUERY = "SELECT MAX(id) FROM BlogPost";
	private static final String UPDATE_BLOG_POST_BY_ID_QUERY = "UPDATE BlogPost SET title=?, contentpreview=?, fullcontent=?, author=?, date=?, likes =? WHERE id=?";
	private static final String DELETE_BLOG_POST_BY_ID_QUERY = "DELETE FROM BlogPost WHERE id=?";

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// App Blog Posts Crude Methods
	@Override
	public void createBlogPosts(BlogPost blogPost) {
		jdbcTemplate.update(INSERT_BLOG_POST_QUERY, blogPost.getId(), blogPost.getTitle(), blogPost.getContentPreview(),
				blogPost.getFullContent(), blogPost.getAuthor(), blogPost.getDate() , blogPost.getLikes());
	}

	@Override
	public void updateBlogPosts(BlogPost blogPost) {
		jdbcTemplate.update(UPDATE_BLOG_POST_BY_ID_QUERY, blogPost.getTitle(), blogPost.getContentPreview(),
				blogPost.getFullContent(), blogPost.getAuthor(), blogPost.getDate(),blogPost.getLikes(), blogPost.getId());
	}

	@Override
	public void deleteBlogPosts(int id) {
		jdbcTemplate.update(DELETE_BLOG_POST_BY_ID_QUERY, id);
	}

	@Override
	public BlogPost getBlogPostById(int id) {
		return jdbcTemplate.queryForObject(GET_BLOG_POST_BY_ID_QUERY,
				(rs, rowNum) -> new BlogPost(rs.getInt("id"), rs.getString("title"), rs.getString("contentpreview"),
						rs.getString("fullcontent"), rs.getString("author"), rs.getString("date"), rs.getInt("likes")),
				id);
	}

	@Override
	public List<BlogPost> getAllBlogPosts() {
		return jdbcTemplate.query(GET_ALL_BLOG_POSTS_QUERY,
				(rs, rowNum) -> new BlogPost(rs.getInt("id"), rs.getString("title"), rs.getString("contentpreview"),
						rs.getString("fullcontent"), rs.getString("author"), rs.getString("date"), rs.getInt("likes")));
	}

	@Override
	public int GetNextBlogPostId() {
		if (jdbcTemplate.queryForObject(GET_NEXT_BLOG_POST_ID_QUERY, Integer.class) == null) {
			return 0;
		} else {
			return jdbcTemplate.queryForObject(GET_NEXT_BLOG_POST_ID_QUERY, Integer.class) + 1;
		}
	}

	// User Blog Posts Crude Methods

	@Override
	public void createUserBlogPosts(BlogPost blogPost) {
		jdbcTemplate.update(INSERT_USER_BLOG_POST_QUERY, blogPost.getId(), blogPost.getTitle(),
				blogPost.getContentPreview(), blogPost.getFullContent(), blogPost.getAuthor(), blogPost.getDate(), blogPost.getLikes());
	}

	@Override
	public void updateUserBlogPosts(BlogPost blogPost) {
		jdbcTemplate.update(UPDATE_USER_BLOG_POST_BY_ID_QUERY, blogPost.getTitle(), blogPost.getContentPreview(),
				blogPost.getFullContent(), blogPost.getAuthor(), blogPost.getDate(), blogPost.getLikes(), blogPost.getId());
	}

	@Override
	public void deleteUserBlogPosts(int id) {
		jdbcTemplate.update(DELETE_USER_BLOG_POST_BY_ID_QUERY, id);
	}

	@Override
	public BlogPost getUserBlogPostById(int id) {
		return jdbcTemplate.queryForObject(GET_USER_BLOG_POST_BY_ID_QUERY,
				(rs, rowNum) -> new BlogPost(rs.getInt("id"), rs.getString("title"), rs.getString("contentPreview"),
						rs.getString("fullContent"), rs.getString("author"), rs.getString("date"), rs.getInt("likes")),
				id);
	}

	@Override
	public List<BlogPost> getAllUserBlogPosts(String username) {

		return jdbcTemplate.query(GET_ALL_USER_BLOG_POSTS_QUERY,
				(rs, rowNum) -> new BlogPost(rs.getInt("id"), rs.getString("title"), rs.getString("contentPreview"),
						rs.getString("fullContent"), rs.getString("author"), rs.getString("date"), rs.getInt("likes")),
				username);

	}

	@Override
	public int GetNextUserBlogPostId() {
		if (jdbcTemplate.queryForObject(GET_NEXT_USER_BLOG_POST_ID_QUERY, Integer.class) == null) {
			return 0;
		} else {
			return jdbcTemplate.queryForObject(GET_NEXT_USER_BLOG_POST_ID_QUERY, Integer.class) + 1;
		}
	}
}
