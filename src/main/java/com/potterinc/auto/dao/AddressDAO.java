package com.potterinc.auto.dao;

public interface AddressDAO {

    Address save(String street, String city, String country);
}
