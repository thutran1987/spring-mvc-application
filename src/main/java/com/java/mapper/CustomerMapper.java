package com.java.mapper;

import com.java.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        int customerId = rs.getInt("customer_id");
        String firstname = rs.getString("first_name");
        String lastname = rs.getString("last_name");
        LocalDate birthdate = null;
        if (rs.getDate("birth_date") != null) {
            birthdate = rs.getDate("birth_date").toLocalDate();
        }
        String phone = rs.getString("phone");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String state = rs.getString("state");
        int points = rs.getInt("points");
        Customer customer = new Customer(customerId,firstname,lastname,birthdate,phone,address,city,state,points);
        return customer;
    }
}
