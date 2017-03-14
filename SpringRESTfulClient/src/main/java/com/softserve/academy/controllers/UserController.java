package com.softserve.academy.controllers;

import com.softserve.academy.models.Phone;
import com.softserve.academy.models.Role;
import com.softserve.academy.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private Role[] rolesArr;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(ModelMap model) {

        final String uri = "http://localhost:8080/service/role/all";

        RestTemplate restTemplate = new RestTemplate();
        rolesArr = restTemplate.getForObject(uri, Role[].class);
        List<Role> roles = Arrays.asList(rolesArr);

        model.addAttribute("user", new User());
        model.addAttribute("roles", roles);

        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {

        final String uri = "http://localhost:8080/service/user/add";

        List<Role> roles = new ArrayList<>();
        roles.add(rolesArr[0]);
        roles.add(rolesArr[2]);
        user.setRoles(roles);
        System.out.println(user);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, user, User.class);

        return "redirect:/user/allUsers";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
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
        restTemplate.put(uri, user, param);

        return "redirect:/user/allUsers";
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam int id) {

        final String uri = "http://localhost:8080/service/user/" + id;
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("id", id);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, param);

        return "redirect:/user/allUsers";
    }


    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public String allUsers(ModelMap model) {

        final String uri = "http://localhost:8080/service/user/all";

        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        List users = Arrays.asList(result);

        model.addAttribute("users", users);

        return "allUsers";
    }
}