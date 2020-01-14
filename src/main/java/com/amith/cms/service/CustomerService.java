package com.amith.cms.service;

import com.amith.cms.dao.CustomerDAO;
import com.amith.cms.exception.CustomerNotFoundException;
import com.amith.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer){

       return customerDAO.save(customer);

    }

    public List<Customer> getCustomer() {

        return customerDAO.findAll();


    }

    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer=customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("THIS IS CREATED BY AMITH BHARADWAJ KH");

        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId,Customer customer){

        customer.setCustomerId(customerId);

        return customerDAO.save(customer);
    }
    public void deleteCustomer(int customerId){

        customerDAO.deleteById(customerId);
    }
}
