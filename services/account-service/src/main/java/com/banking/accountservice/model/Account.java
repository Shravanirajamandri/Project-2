package com.banking.accountservice.model;
    import jakarta.persistence.*;
    import java.math.BigDecimal;

    @Entity
    @Table(name="accounts")
    public class Account {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        private Long customerId;
private String accountNumber;
private String accountType;
private BigDecimal balance;
private String status;

        public Account() {}
        public Account(Long id, Long customerId, String accountNumber, String accountType, BigDecimal balance, String status) {
            this.id = id;
            this.customerId = customerId;
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.balance = balance;
    this.status = status;
        }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public Long getCustomerId() { return customerId; }
public void setCustomerId(Long customerId) { this.customerId = customerId; }
public String getAccountNumber() { return accountNumber; }
public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
public String getAccountType() { return accountType; }
public void setAccountType(String accountType) { this.accountType = accountType; }
public BigDecimal getBalance() { return balance; }
public void setBalance(BigDecimal balance) { this.balance = balance; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
    }
