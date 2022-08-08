package com.DBS.Transaction.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DBS.Transaction.Model.Customer;
import com.DBS.Transaction.Model.Payment_Transfertypes;
import com.DBS.Transaction.Model.Transaction;
import com.DBS.Transaction.Repository.Customer_Repository;
import com.DBS.Transaction.Repository.TransactionRepository;
import com.DBS.Transaction.Service.TransactionService;

@RestController
@RequestMapping("payment/transaction")

public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private Customer_Repository customer_Repository;

	@GetMapping("/findall")
	public List<Transaction> findallTransaction() {
		return transactionService.findallTransactions();
	}

	@PostMapping("/add")
	private Transaction addTransaction(@RequestBody Transaction transaction) {
		
		return transactionService.addTransaction(transaction);
		
	}
	@PostMapping("/makeTransaction")
	public String makeTransaction(@RequestBody Transaction transaction) {
		   transactionService.makeTransaction(transaction);
		  return "Transaction Successfull";
		
	}

	@GetMapping("/findbyid/{transactionid}")
	public Transaction Findbyid(@PathVariable Long transactionid ) {
		Optional<Transaction> dataOptional = transactionRepository.findById(transactionid);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			return new Transaction();
		}
	}

	@PutMapping("/update")
	public Transaction updateTransaction(@RequestBody Transaction transaction) {
		return transactionRepository.save(transaction);
}
	
}
