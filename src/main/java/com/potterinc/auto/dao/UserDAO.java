package com.potterinc.auto.dao;

import java.util.List;

public interface UserDAO {

    boolean save(String firstName, String lastName, String email, String password, String phone, Address address);
    User getByEmailAndPassword(String email, String password);
    List<User> getAll();
    User getById(Integer id);
}
