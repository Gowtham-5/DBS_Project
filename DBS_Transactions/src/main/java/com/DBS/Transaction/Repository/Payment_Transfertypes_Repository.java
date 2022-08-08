package com.DBS.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DBS.Transaction.Model.Payment_Transfertypes;
@Repository
public interface Payment_Transfertypes_Repository extends JpaRepository<Payment_Transfertypes, String> {

}
