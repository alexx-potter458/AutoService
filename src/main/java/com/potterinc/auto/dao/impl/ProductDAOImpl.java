package com.potterinc.auto.dao.impl;

import com.potterinc.auto.dao.Product;
import com.potterinc.auto.dao.ProductDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<Product> getAll() {
        String serviceList = "SELECT * FROM auto.service;";
        Query q = em.createNativeQuery(serviceList, Product.class);

        return (List<Product>) q.getResultList();

    }

    @Override
    public Product getById(Integer id) {
        return em.find(Product.class, id);
    }
}
