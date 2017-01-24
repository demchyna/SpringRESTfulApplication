package com.softserve.academy.services;

import com.softserve.academy.mappers.BlogMapper;
import com.softserve.academy.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Transactional
    public Blog getPostById(int id) {
        Blog blog = blogMapper.getPostById(id);
        if (blog != null) {
            return blog;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }
}