package com.softserve.academy.controllers;

import com.softserve.academy.models.User;
import com.softserve.academy.services.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        LOGGER.info("New User was created");
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User getUserById(@PathVariable int id, HttpServletResponse response) throws IOException {
        try {
            User user = userService.getUserById(id);
            LOGGER.info("User with id " + id + " was retrieved");
            return user;
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("User with id " + id + " was not found: " + e);
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public User updateUser(@PathVariable int id, @RequestBody User user, HttpServletResponse response) throws IOException {
        try {
            userService.updateUser(id, user);
            LOGGER.info("User with id " + id + " was updated");
            return userService.getUserById(id);
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("User with id " + id + " was not found: " + e);
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id, HttpServletResponse response) throws IOException {
        try {
            userService.deleteUser(id);
            LOGGER.info("User with id " + id + " was deleted");
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("User with id " + id + " was not found: " + e);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getAllUser(HttpServletResponse response) throws IOException {
        try {
            List<User> users = userService.getAllUsers();
            LOGGER.info("All Users were retrieved");
            return users;
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("Nothing Users were not found: " + e);
            return null;
        }
    }

    @RequestMapping(value = "/phone/{phone}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User getUserByPhone(@PathVariable int phone) {
        User user = userService.getUserByPhone(phone);
        return user;
    }

    @RequestMapping(value = "/role/{role}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRole(role);
        return users;
    }
}