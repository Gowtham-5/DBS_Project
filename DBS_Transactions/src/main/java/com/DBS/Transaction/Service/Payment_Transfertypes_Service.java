package com.DBS.Transaction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DBS.Transaction.Model.Payment_Transfertypes;
import com.DBS.Transaction.Repository.Payment_Transfertypes_Repository;

@Service
public class Payment_Transfertypes_Service {
	@Autowired
	private Payment_Transfertypes_Repository payment_Transfertypes_Repository;
	public List<Payment_Transfertypes> Payament_Transfertypes_List(){
		return payment_Transfertypes_Repository.findAll();
	}
	public Payment_Transfertypes Add_Payment_Transfertype(@RequestBody Payment_Transfertypes payment_Transfertypes) {
	 return payment_Transfertypes_Repository.save(payment_Transfertypes);
	}

}
