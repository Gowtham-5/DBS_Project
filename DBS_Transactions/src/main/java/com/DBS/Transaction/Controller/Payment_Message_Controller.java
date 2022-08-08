package com.DBS.Transaction.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DBS.Transaction.Model.Payment_Message;
import com.DBS.Transaction.Service.Payment_Message_Service;

@RestController
@RequestMapping("/payment/message")
public class Payment_Message_Controller {
    @Autowired
    private Payment_Message_Service payment_Message_Service;

    @PostMapping("/add")
    public Payment_Message addPayment_Message(@RequestBody Payment_Message payment_Message) {
        return payment_Message_Service.Add_Payment_Messagecode(payment_Message);
    }
    @GetMapping("/findall")
    public List<Payment_Message> getListOfPayment_Message(){
        return payment_Message_Service.Payment_Message_List();

    }


}
