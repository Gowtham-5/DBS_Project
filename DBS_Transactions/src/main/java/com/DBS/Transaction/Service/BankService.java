package com.DBS.Transaction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DBS.Transaction.Model.Bank;
import com.DBS.Transaction.Repository.BankRepository;

@Service
public class BankService {
	@Autowired
	private BankRepository bankRepository;
	public List<Bank> findAllBanks() {
		return bankRepository.findAll();
		
	}
	public Bank addBanks(@RequestBody Bank bank) {
		return bankRepository.save(bank);
	}
	
}
