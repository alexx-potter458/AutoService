package com.potterinc.auto.dao;

import java.util.List;

public interface ProductDAO {

    List<Product> getAll();
    Product getById(Integer id);
}
