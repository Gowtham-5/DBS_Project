package com.DBS.Transaction.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.HdrHistogram.DoubleRecordedValuesIterator;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.DBS.Transaction.Model.Customer;
import com.DBS.Transaction.Model.Transaction;
import com.DBS.Transaction.Repository.Customer_Repository;
import com.DBS.Transaction.Repository.TransactionRepository;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeDeserializer;

import antlr.MakeGrammar;
import antlr.collections.List;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private Customer_Repository customer_Repository;
	
//	public Transaction addTransaction(@RequestBody Transaction transaction) {
//		Customer customer= customer_Repository.findById(transaction.getCustomers().getCustomerid()).get();
//		transaction.setCustomers(customer);
//		return transactionRepository.save(transaction);
//			
//	}
	public java.util.List<Transaction> findallTransactions(){
		return transactionRepository.findAll();
	}
	
	public String makeTransaction(Transaction transaction) throws IOException {
		String receivername = transaction.getReceiveraccountholdername();
		Double amount= transaction.getAmount();
		Integer id=transaction.getCustomers().getCustomerid();
		Customer customer2= customer_Repository.findById(id).get();
		Double transferfee= transaction.getTransferfees();
		Customer receiverCustomer= customer_Repository.findById(transaction.getReceiveraccountholdernumber()).get();
		if (checkReceiverName(receivername)) {
			return "Receiver is Blocklisted";
		}
		else {
			if (!customer2.getOverdraftflag()&& customer2.getClearbalance()<amount) {
				return "Insufficient Balance";
			
	    	}
			else {
				Double finalBalance= customer2.getClearbalance()-amount-transferfee;
				customer2.setClearbalance(finalBalance);
				transaction.setCustomers(customer2);
				receiverCustomer.setClearbalance(receiverCustomer.getClearbalance()+amount);
				transaction.setCustomers(receiverCustomer);
		    	transaction.setTransferfees(transferfee);
				transactionRepository.save(transaction);
				return "Transaction Successful";
			}
		}
		
		
    }
	public boolean checkReceiverName(String banString) throws IOException {
        File file = new File("./src/main/resources/sdnlist.txt");
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String st;
            Set<String> data=new HashSet<>();
            while ((st = br.readLine()) != null)
            {
                java.util.List<String> lineData=Arrays.asList(st.split("[-+\\/.,; \"()@]"));
                lineData=lower(lineData);
                data.addAll(lineData);
            }
            java.util.List<String> nameSplit=Arrays.asList(banString.split("[-+\\/.,; \"()@]"));
            nameSplit=lower(nameSplit);
            for(String s:nameSplit)
            {
                
                if(!data.contains(s))
                {
                    return(false);
                }
            }
        }
        return(true);
    }



   private static java.util.List<String> lower(java.util.List<String> names) {
        return names.stream().map((name)->name.toLowerCase()).collect(Collectors.toList());
    }
}
