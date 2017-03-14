package com.softserve.academy.services;

import com.softserve.academy.dao.BlogDAO;
import com.softserve.academy.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogDAO blogDAO;

    public void addPost(Blog blog) {
        blogDAO.addPost(blog);
    }

    public Blog getPostById(int id) {
        Blog blog = blogDAO.getPostById(id);
        if (blog != null) {
            return blog;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    public List<Blog> getPostsByUserId(int id) {
        List<Blog> posts = blogDAO.getPostsByUserId(id);
        if (!posts.isEmpty()) {
            return posts;
        } else {
            throw new RuntimeException("Resources not found");
        }
    }
}