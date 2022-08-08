package com.DBS.Transaction.Controller;

import java.util.List;
import java.util.Optional;

import org.springdoc.core.converters.models.MonetaryAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DBS.Transaction.Model.Customer;
import com.DBS.Transaction.Repository.Customer_Repository;
import com.DBS.Transaction.Service.Customer_Service;

@RestController
@RequestMapping("/payment/customer")
public class Customer_Controller {

    @Autowired
    private Customer_Repository customer_Repository;

    @Autowired
    private Customer_Service customer_Service;

    @PostMapping("/add")
    public Customer AddCustomer(@RequestBody Customer customer) {
        return customer_Service.AddCustomer(customer);
    }

    @GetMapping("/findall")
    public List<Customer> getListofCustomer(){
        return customer_Service.Customer_List();
    }
    @GetMapping("custid/{customerid}/get")
    public Customer findById(@PathVariable Integer customerid) {

    	return customer_Service.findCustomerById(customerid);
    }
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
    	return customer_Repository.save(customer);
    }
//    @PutMapping("/updateamount/{customerid}/{customer1}")
//    public String updateBalance( Integer customerid,  Double amount) {
//    	customer_Service.updateAmount(customerid, amount);
//    	return "Amount updated";
//    }

}
