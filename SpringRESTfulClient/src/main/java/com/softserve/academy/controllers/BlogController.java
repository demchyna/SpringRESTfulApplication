package com.softserve.academy.controllers;

import com.softserve.academy.models.Blog;
import com.softserve.academy.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public String addPost(ModelMap model) {

        final String uri = "http://localhost:8080/service/user/all";

        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        List<User> users = Arrays.asList(result);

        model.addAttribute("blog", new Blog());
        model.addAttribute("users", users);

        return "addPost";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("blog") Blog user) {

        final String uri = "http://localhost:8080/service/blog/add";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, user, Blog.class);

        return "redirect:/user/allUsers";
    }

    @RequestMapping(value = "/getUserPosts", method = RequestMethod.GET)
    public String getPostsBuUserId(@RequestParam int id, ModelMap model) {

        final String uri1 = "http://localhost:8080/service/blog/" + id + "/posts";

        RestTemplate restTemplate = new RestTemplate();
        Blog[] result = restTemplate.getForObject(uri1, Blog[].class);
        List posts = Arrays.asList(result);

        final String uri2 = "http://localhost:8080/service/user/" + id;

        restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri2, User.class);

        model.addAttribute("posts", posts);
        model.addAttribute("user", user);

        return "userPosts";
    }

}
