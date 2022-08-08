package com.DBS.Transaction.Service;

import java.util.Optional;

import org.HdrHistogram.DoubleRecordedValuesIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.DBS.Transaction.Model.Customer;
import com.DBS.Transaction.Model.Transaction;
import com.DBS.Transaction.Repository.Customer_Repository;
import com.DBS.Transaction.Repository.TransactionRepository;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeDeserializer;

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
	
	public Transaction makeTransaction(Transaction transaction) {
		Double amount= transaction.getAmount();
		Integer id=transaction.getCustomers().getCustomerid();
		Customer customer2= customer_Repository.findById(id).get();
		Double transferfee= (amount*0.25)/100;
		Double finalBalance= customer2.getClearbalance()-amount-transferfee;
    	customer2.setClearbalance(finalBalance);
    	transaction.setCustomers(customer2);
    	transaction.setTransferfees(transferfee);
		return transactionRepository.save(transaction);
	
		
		
	}
 
}
