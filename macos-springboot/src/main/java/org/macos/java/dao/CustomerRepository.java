package org.macos.java.dao;

import org.macos.java.model.Customer;

import java.util.Map;

public interface CustomerRepository {
    void save(Customer customer);
    Customer find(Long id);
    Map<Long, Customer> findAll();
    void update(Customer customer);
    void delete(Long id);
}
