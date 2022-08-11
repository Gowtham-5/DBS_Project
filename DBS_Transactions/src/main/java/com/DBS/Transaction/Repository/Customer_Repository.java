package com.DBS.Transaction.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DBS.Transaction.Model.Customer;

@Repository
public interface Customer_Repository extends JpaRepository<Customer, Integer> {
	//public Optional<Customer> findByAccountholdername(String accountholdername);

}
