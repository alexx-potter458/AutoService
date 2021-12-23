package com.potterinc.auto.service;

import com.potterinc.auto.dao.Product;
import com.potterinc.auto.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public Product getById(Integer id) {
        return productDAO.getById(id);

    }
}
