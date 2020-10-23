package com.java.service;

import com.java.dao.CustomerDao;
import com.java.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    public void insertCustomer(Customer customer) {
        customerDao.insertCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
