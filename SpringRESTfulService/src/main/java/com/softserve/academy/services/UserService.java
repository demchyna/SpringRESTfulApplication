package com.softserve.academy.services;

import com.softserve.academy.dao.UserDAO;
import com.softserve.academy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

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
            userDAO.updateUser(newUser);
        }
    }

    public void deleteUser(int id) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            userDAO.deleteUser(id);
        } else {
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