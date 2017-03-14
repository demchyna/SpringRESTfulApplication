package com.softserve.academy.dao;

import com.softserve.academy.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public User getUserById(int id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public void deleteUser(int id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Transactional
    public List<User> getAllUsers() {
        @SuppressWarnings("unchecked")
        List<User> users = sessionFactory.getCurrentSession().createQuery("FROM User").list();
        if (!users.isEmpty()) {
            return users;
        }
        return null;
    }

}
