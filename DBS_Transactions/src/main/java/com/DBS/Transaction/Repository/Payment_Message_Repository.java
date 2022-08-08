package com.DBS.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DBS.Transaction.Model.Payment_Message;

@Repository
public interface Payment_Message_Repository extends JpaRepository<Payment_Message, String> {

}
