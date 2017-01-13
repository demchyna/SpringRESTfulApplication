package com.softserve.academy.services;

import com.softserve.academy.models.User;
import com.softserve.academy.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public User getUserById(int id) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    public void updateUser(int id, User newUser) {
        User oldUser = userDAO.getUserById(id);
        if (oldUser != null) {
            newUser.setCreateDate(oldUser.getCreateDate());
            userDAO.updateUser(id, newUser);
        }
    }

    public void deleteUser(int id) {
        int rowCount = userDAO.deleteUser(id);
        if (rowCount == 0) {
            throw new RuntimeException("Resource not found");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        if (!users.isEmpty()) {
            return users;
        } else {
            throw new RuntimeException("Resources not found");
        }
    }
}