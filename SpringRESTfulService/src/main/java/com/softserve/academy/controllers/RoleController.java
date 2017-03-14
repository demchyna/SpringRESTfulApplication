package com.softserve.academy.controllers;

import com.softserve.academy.models.Role;
import com.softserve.academy.services.RoleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Role getRoleById(@PathVariable int id, HttpServletResponse response) throws IOException {
        try {
            Role role = roleService.getRoleById(id);
            LOGGER.info("Role with id " + id + " was retrieved");
            return role;
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("Role with id " + id + " was not found: " + e);
            return null;
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Role> getAllRoles(HttpServletResponse response) throws IOException {
        try {
            List<Role> roles = roleService.getAllRoles();
            LOGGER.info("All Roles were retrieved");
            return roles;
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOGGER.error("Nothing Roles were not found: " + e);
            return null;
        }
    }
}