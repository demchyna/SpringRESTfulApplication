package com.softserve.academy.controllers;

import com.softserve.academy.models.Blog;
import com.softserve.academy.services.BlogService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Blog addPost(@RequestBody Blog blog) {
        blogService.addPost(blog);
        LOGGER.info("New Post was created");
        return blog;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Blog getPostById(@PathVariable int id, HttpServletResponse response) throws IOException {
        try {
            Blog blog = blogService.getPostById(id);
            LOGGER.info("Post with id " + id + " was retrieved");
            return blog;
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("Post with id " + id + " was not found: " + e);
            return null;
        }
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Blog> getPostsByUserId(@PathVariable int id, HttpServletResponse response) throws IOException {

        try {
            List<Blog> posts = blogService.getPostsByUserId(id);
            LOGGER.info("All Posts were retrieved");
            return posts;
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("Nothing Posts were not found: " + e);
            return null;
        }
    }
}