package com.softserve.academy.dao;

import com.softserve.academy.models.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Transactional
    public Role getRoleById(int id) {
        Role role = sessionFactory.getCurrentSession().get(Role.class, id);
        if (role != null) {
            return role;
        }
        return null;
    }

    @Transactional
    public void updateRole(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    @Transactional
    public void deleteRole(int id) {
        Role role = sessionFactory.getCurrentSession().get(Role.class, id);
        if (role != null) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }

    @Transactional
    public List<Role> getAllRoles() {
        @SuppressWarnings("unchecked")
        List<Role> roles = sessionFactory.getCurrentSession().createQuery("FROM Role").list();
        if (!roles.isEmpty()) {
            return roles;
        }
        return null;
    }
}