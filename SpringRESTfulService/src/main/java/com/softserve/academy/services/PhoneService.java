package com.softserve.academy.services;

import com.softserve.academy.dao.PhoneDAO;
import com.softserve.academy.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;

    public void addPhone(Phone phone) {
        phoneDAO.addPhone(phone);
    }

    public Phone getPhoneById(int id) {
        Phone phone = phoneDAO.getPhoneById(id);
        if (phone != null) {
            return phone;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    public void updatePhone(int id, Phone newPhone) {
        Phone oldPhone = phoneDAO.getPhoneById(id);
        if (oldPhone != null) {
            phoneDAO.updatePhone(newPhone);
        }
    }

    public void deletePhone(int id) {
        Phone phone = phoneDAO.getPhoneById(id);
        if (phone != null) {
            phoneDAO.deletePhone(id);
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    public List<Phone> getAllPhones() {
        List<Phone> phones = phoneDAO.getAllPhones();
        if (!phones.isEmpty()) {
            return phones;
        } else {
            throw new RuntimeException("Resources not found");
        }
    }
}