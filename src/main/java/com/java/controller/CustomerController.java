package com.java.controller;

import com.java.dto.CustomerDto;
import com.java.model.Customer;
import com.java.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/getCustomer")
    public String viewCustomer(Model model) {
        List<Customer> customers = customerService.getAllCustomer();
        model.addAttribute("customers",customers);
        return "Customer";
    }

    @RequestMapping("/create-customer")
    public String viewCreateCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create-customer";
    }

    @RequestMapping("/submit-create-customer")
    public String submitCreateCustomer(@ModelAttribute("customer") CustomerDto customerDto, Model model) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDto,Customer.class);
        customer.setBirthdate(customerDto.parseBirthdateToLocalDate());
        customerService.insertCustomer(customer);
        model.addAttribute("customerDto",customerDto);
        return "submit-create-customer";
    }

    @RequestMapping("/edit-customer/{id}")
    public String viewEditCustomer(Model model, @PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @RequestMapping("/submit-edit-customer/{id}")
    public String submitEditCustomer(@ModelAttribute("customer") CustomerDto customerDto, Model model, @PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDto,Customer.class);
        customer.setBirthdate(customerDto.parseBirthdateToLocalDate());
        customer.setCustomerId(id);
        customerService.editCustomer(customer);
        model.addAttribute("customerDto",customerDto);
        return "submit-edit-customer";
    }

    @RequestMapping("/delete-customer/{id}")
    public String viewDeleteCustomer(Model model, @PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "delete-customer";
    }

    @RequestMapping("/submit-delete-customer/{id}")
    public String submitDeleteCustomer(Model model, @PathVariable int id,String action) {
        if(action.equals("Delete")) {
            Customer customer = customerService.getCustomerById(id);
            customerService.deleteCustomer(id);
            model.addAttribute("customerDto", customer);
            return "submit-delete-customer";
        }
        return "redirect:/getCustomer";
    }


}
