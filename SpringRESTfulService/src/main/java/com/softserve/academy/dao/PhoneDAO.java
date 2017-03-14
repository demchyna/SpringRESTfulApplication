package com.softserve.academy.dao;

import com.softserve.academy.models.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PhoneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addPhone(Phone phone) {
        sessionFactory.getCurrentSession().save(phone);
    }

    @Transactional
    public Phone getPhoneById(int id) {
        Phone phone = sessionFactory.getCurrentSession().get(Phone.class, id);
        if (phone != null) {
            return phone;
        }
        return null;
    }

    @Transactional
    public void updatePhone(Phone phone) {
        sessionFactory.getCurrentSession().update(phone);
    }

    @Transactional
    public void deletePhone(int id) {
        Phone phone = sessionFactory.getCurrentSession().get(Phone.class, id);
        if (phone != null) {
            sessionFactory.getCurrentSession().delete(phone);
        }
    }

    @Transactional
    public List<Phone> getAllPhones() {
        @SuppressWarnings("unchecked")
        List<Phone> phones = sessionFactory.getCurrentSession().createQuery("FROM Phone").list();
        if (!phones.isEmpty()) {
            return phones;
        }
        return null;
    }
}
