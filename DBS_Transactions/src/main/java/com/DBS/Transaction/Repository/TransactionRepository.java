package com.DBS.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DBS.Transaction.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
