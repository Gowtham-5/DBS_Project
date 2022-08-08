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

import com.DBS.Transaction.Model.Bank;
import com.DBS.Transaction.Model.Payment_Transfertypes;
import com.DBS.Transaction.Repository.BankRepository;
import com.DBS.Transaction.Service.BankService;

@RestController
@RequestMapping("/payment/banks")
public class BankController {
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private BankService bankService;

	@PostMapping("/add")
	public Bank addBank(@RequestBody Bank bank) {
		return bankService.addBanks(bank);
	}
	@GetMapping("/findbyid/{bic}/get")
	public Bank findbyIdBank(@PathVariable String bic) {
		Optional<Bank> data= bankRepository.findById(bic);
		if (data.isPresent()) {
			return data.get();
		}
		else {
			return new Bank();
		}
	}
	@DeleteMapping("/delete/{bic}")
	public String deletebyidbank(@PathVariable String bic) {
		bankRepository.deleteById(bic);
		return "deleted";
	}
	@PutMapping("/update")
	public String updateBanks(@RequestBody Bank bank) {
		bankRepository.save(bank);
		return "update";
	}
	@GetMapping("/findall")
	public List<Bank> finallBanks(){
		return bankService.findAllBanks();
	}
		
	

}
