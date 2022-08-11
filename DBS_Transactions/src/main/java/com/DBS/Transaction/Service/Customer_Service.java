package com.DBS.Transaction.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DBS.Transaction.Model.Customer;
import com.DBS.Transaction.Repository.Customer_Repository;

@Service
public class Customer_Service {

    @Autowired
    private Customer_Repository customer_Repository;

    public List<Customer> Customer_List(){
        return customer_Repository.findAll(); 
    }

    public Customer AddCustomer(@RequestBody Customer customer) {
        return customer_Repository.save(customer);
    }
    public Customer findCustomerById(Integer customerid) {
    	Optional<Customer> data=customer_Repository.findById(customerid);
        if (data.isPresent()) {
            return data.get();
        }
        else {
            return new Customer();
        }
    }
//    public Optional<Customer> findcustomerbyname(String accountholdername) {
//    	return customer_Repository.findByAccountholdername(accountholdername);
//    }
}
