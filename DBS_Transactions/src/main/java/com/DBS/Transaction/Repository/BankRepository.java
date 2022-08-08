package com.DBS.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DBS.Transaction.Model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String>{

}
