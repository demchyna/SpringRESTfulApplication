package com.softserve.academy.controllers;

import com.softserve.academy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    PasswordEncoder passEncoder;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    //@Secured("ROLE_ADMIN")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {

        final String uri = "http://localhost:8080/service/user/add";

        RestTemplate restTemplate = new RestTemplate();

        user.setPassword(passEncoder.encode(user.getPassword()));

        restTemplate.postForObject(uri, user, User.class);

        return "redirect:/user/allUsers";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String editUser(@RequestParam int id, ModelMap model) {

        final String uri = "http://localhost:8080/service/user/" + id;

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri, User.class);

        model.addAttribute("user", user);

        return "editUser";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@RequestParam int id, @ModelAttribute("user") User user) {

        final String uri = "http://localhost:8080/service/user/" + id;
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("id", id);

        RestTemplate restTemplate = new RestTemplate();

        user.setPassword(passEncoder.encode(user.getPassword()));

        restTemplate.put(uri, user, param);

        return "redirect:/user/allUsers";
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@RequestParam int id) {

        final String uri = "http://localhost:8080/service/user/" + id;
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("id", id);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, param);

        return "redirect:/user/allUsers";
    }


    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String allUsers(ModelMap model) {

        final String uri = "http://localhost:8080/service/user/all";

        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        List users = Arrays.asList(result);

        model.addAttribute("users", users);

        return "allUsers";
    }
}