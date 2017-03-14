package com.softserve.academy.services;

import com.softserve.academy.dao.RoleDAO;
import com.softserve.academy.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role getRoleById(int id) {
        Role role = roleDAO.getRoleById(id);
        if (role != null) {
            return role;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    public List<Role> getAllRoles() {
        List<Role> roles = roleDAO.getAllRoles();
        if (!roles.isEmpty()) {
            return roles;
        } else {
            throw new RuntimeException("Resources not found");
        }
    }

}