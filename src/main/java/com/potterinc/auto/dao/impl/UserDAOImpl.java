package com.potterinc.auto.dao.impl;

import com.potterinc.auto.dao.Address;
import com.potterinc.auto.dao.User;
import com.potterinc.auto.dao.UserDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public boolean save(String firstName, String lastName, String email, String password, String phone, Address address) {
        User u = new User();

        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setPhone(phone);
        u.setPassword(password);
        u.setAddress(address);

        em.persist(u);
        return true;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        String userQuery = "SELECT * FROM `auto`.`user` WHERE email = '" + email + "' AND password = '" + password + "'";
        Query q = em.createNativeQuery(userQuery, User.class);
        return (User)q.getSingleResult();
    }

    @Override
    public List<User> getAll() {
        String userQuery = "SELECT * FROM `auto`.`user`";
        Query q = em.createNativeQuery(userQuery, User.class);
        List<User> users = q.getResultList();

        return users;
    }

    @Override
    public User getById(Integer id) {
        return em.find(User.class, id);
    }
}
