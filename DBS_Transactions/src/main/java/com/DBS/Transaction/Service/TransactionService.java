package com.DBS.Transaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.DBS.Transaction.Model.Customer;
import com.DBS.Transaction.Model.Transaction;
import com.DBS.Transaction.Repository.Customer_Repository;
import com.DBS.Transaction.Repository.TransactionRepository;

import antlr.MakeGrammar;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private Customer_Repository customer_Repository;
	
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		Customer customer= customer_Repository.findById(transaction.getCustomers().getCustomerid()).get();
		transaction.setCustomers(customer);
		return transactionRepository.save(transaction);
			
	}
	public java.util.List<Transaction> findallTransactions(){
		return transactionRepository.findAll();
	}
	
	
 
}
