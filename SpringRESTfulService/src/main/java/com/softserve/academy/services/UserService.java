package com.softserve.academy.services;

import com.softserve.academy.models.User;
import com.softserve.academy.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Transactional
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    @Transactional
    public void updateUser(int id, User newUser) {
        User oldUser = userMapper.getUserById(id);
        if (oldUser != null) {
            newUser.setCreateDate(oldUser.getCreateDate());
            userMapper.updateUser(newUser);
        }
    }

    @Transactional
    public void deleteUser(int id) {
        User user = userMapper.getUserById(id);
        if (user != null) {
            userMapper.deleteUser(id);
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> users = userMapper.getAllUsers();
        if (!users.isEmpty()) {
            return users;
        } else {
            throw new RuntimeException("Resources not found");
        }
    }

    @Transactional
    public User getUserByPhone(int phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Transactional
    public List<User> getUsersByRole(String role) {
        return userMapper.getUsersByRole(role);
    }
}