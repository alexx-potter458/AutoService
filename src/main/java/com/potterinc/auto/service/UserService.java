package com.potterinc.auto.service;

import com.potterinc.auto.dao.Address;
import com.potterinc.auto.dao.AddressDAO;
import com.potterinc.auto.dao.User;
import com.potterinc.auto.dao.UserDAO;
import com.potterinc.auto.dto.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    AddressDAO addressDAO;

    public boolean add(RegisterForm data) {
        if( !data.getPassword().equals(data.getPassword2())) {
            return false;
        }

        Address address = addressDAO.save("X", "Y", "Z");

        return userDAO.save(data.getFirstName(), data.getLastName(), data.getEmail(), data.getPassword(), data.getPhone(), address);
    }

    public User getByEmailAndPassword(String email, String password) {

        return userDAO.getByEmailAndPassword(email, password);
    }

    public List<User> getAll() {

        return userDAO.getAll();
    }

    public User getById(Integer id) {

        return  userDAO.getById(id);
    }
}
