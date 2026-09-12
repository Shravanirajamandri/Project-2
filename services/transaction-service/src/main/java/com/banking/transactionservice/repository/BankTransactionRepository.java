package com.banking.transactionservice.repository;
import com.banking.transactionservice.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {}
