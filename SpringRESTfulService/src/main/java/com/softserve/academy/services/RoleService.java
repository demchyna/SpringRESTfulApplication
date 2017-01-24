package com.softserve.academy.services;

import com.softserve.academy.mappers.RoleMapper;
import com.softserve.academy.models.Role;
import com.softserve.academy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Transactional
    public Role getRoleById(int id) {
        Role role = roleMapper.getRoleById(id);
        if (role != null) {
            return role;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }
}