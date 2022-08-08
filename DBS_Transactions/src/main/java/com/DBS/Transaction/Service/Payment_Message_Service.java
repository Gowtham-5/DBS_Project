package com.DBS.Transaction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DBS.Transaction.Model.Payment_Message;
import com.DBS.Transaction.Repository.Payment_Message_Repository;


@Service
public class Payment_Message_Service {

    @Autowired
    private Payment_Message_Repository payment_Message_Repository;

    public List<Payment_Message> Payment_Message_List(){
        return payment_Message_Repository.findAll();
    }
    public Payment_Message  Add_Payment_Messagecode(@RequestBody Payment_Message payment_Message ) {
        return payment_Message_Repository.save(payment_Message);
    }

}
