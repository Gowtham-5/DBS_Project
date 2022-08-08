package com.DBS.Transaction.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DBS.Transaction.Model.Payment_Transfertypes;
import com.DBS.Transaction.Repository.Payment_Transfertypes_Repository;
import com.DBS.Transaction.Service.Payment_Transfertypes_Service;

import ch.qos.logback.core.joran.spi.ElementSelector;

@RestController
@RequestMapping("/payment/transfertypes")
public class Payment_Transfertypes_Controller {

	private static final Logger log = LoggerFactory.getLogger(Payment_Transfertypes_Controller.class);

	@Autowired
	private Payment_Transfertypes_Service payment_Transfertypes_Service;
	@Autowired
	private Payment_Transfertypes_Repository payment_Transfertypes_Repository;

	@PostMapping("/add")
	public Payment_Transfertypes addPayment_Transfertypes(@RequestBody Payment_Transfertypes payment_Transfertypes) {
		return payment_Transfertypes_Service.Add_Payment_Transfertype(payment_Transfertypes);
	}

	@GetMapping("/findall")
	public List<Payment_Transfertypes> getListOfPayment_Transfertypes() {
		return payment_Transfertypes_Service.Payament_Transfertypes_List();
	}

	@GetMapping("/findbyid/{transfertypecode}/get")
	public Payment_Transfertypes getPayment_TransfertypesById(@PathVariable String transfertypecode) {
		log.info("We are going to retreive ID : " + transfertypecode);
		Optional<Payment_Transfertypes> dataOptional = payment_Transfertypes_Repository.findById(transfertypecode);
		if (dataOptional.isPresent()) {
			return dataOptional.get();
		} else {
			return new Payment_Transfertypes();
		}	}

	@DeleteMapping("deletebyid/{transfertypecode}")
	public Payment_Transfertypes deleteByIdPayment_Transfertypes(@PathVariable String transfertypecode) {
	Payment_Transfertypes payment_Transfertypes=	payment_Transfertypes_Repository.findById(transfertypecode).get();
		payment_Transfertypes_Repository.deleteById(transfertypecode);
		return payment_Transfertypes;
	}
	@PutMapping("/Update")
	public Payment_Transfertypes updatePayment_Transfertypes(@RequestBody Payment_Transfertypes payment_Transfertypes) {
		return payment_Transfertypes_Repository.save(payment_Transfertypes);
	}
}
