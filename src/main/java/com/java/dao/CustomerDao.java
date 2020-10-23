package com.java.dao;

import com.java.mapper.CustomerMapper;
import com.java.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomer() {
        String sql = "SELECT customer_id,first_name,last_name,birth_date,phone,address,city,state,points\n" +
                "FROM customers";
        return jdbcTemplate.query(sql,new CustomerMapper());
    }

    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customers (first_name, last_name, birth_date, phone, address, city, state, points) VALUE(:fistname, :lastname, :birthdate, :phone, :address, :city, :state, :points)";
        Map<String,Object> mapCustomer = new HashMap<>();
        mapCustomer.put("fistname",customer.getFirstname());
        mapCustomer.put("lastname",customer.getLastname());
        mapCustomer.put("birthdate",customer.getBirthdate());
        mapCustomer.put("phone",customer.getPhone());
        mapCustomer.put("address",customer.getAddress());
        mapCustomer.put("city",customer.getCity());
        mapCustomer.put("state",customer.getState());
        mapCustomer.put("points",customer.getPoints());
        namedParameterJdbcTemplate.update(sql,mapCustomer);
    }

    public Customer getCustomerById (int id) {
        String sql = "SELECT customer_id,first_name,last_name,birth_date,phone,address,city,state,points\n" +
                "FROM customers " +
                "WHERE customer_id = :customerId";
        Map<String,Integer> param = new HashMap<>();
        param.put("customerId",id);
        return namedParameterJdbcTemplate.queryForObject(sql,param,new CustomerMapper());
    }

    public void editCustomer(Customer customer) {
        String sql = "UPDATE customers SET first_name = :fistname, last_name = :lastname, birth_date = :birthdate, phone = :phone, address = :address, city = :city, state = :state, points = :points " +
                "WHERE customer_id = :customerId";
        Map<String,Object> mapCustomer = new HashMap<>();
        mapCustomer.put("fistname",customer.getFirstname());
        mapCustomer.put("lastname",customer.getLastname());
        mapCustomer.put("birthdate",customer.getBirthdate());
        mapCustomer.put("phone",customer.getPhone());
        mapCustomer.put("address",customer.getAddress());
        mapCustomer.put("city",customer.getCity());
        mapCustomer.put("state",customer.getState());
        mapCustomer.put("points",customer.getPoints());
        mapCustomer.put("customerId",customer.getCustomerId());
        namedParameterJdbcTemplate.update(sql,mapCustomer);
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE customer_id = :customerId";
        Map<String,Integer> param = new HashMap<>();
        param.put("customerId",id);
        namedParameterJdbcTemplate.update(sql,param);
    }
}
