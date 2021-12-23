package com.potterinc.auto.dao.impl;

import com.potterinc.auto.dao.Address;
import com.potterinc.auto.dao.AddressDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressDAOImpl implements AddressDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Address save(String street, String city, String country) {
        Address a = new Address();

        a.setCity(city);
        a.setCountry(country);
        a.setStreet(street);

        em.persist(a);
        return a;
    }
}
