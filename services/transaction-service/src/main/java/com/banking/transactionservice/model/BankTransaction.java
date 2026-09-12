package com.banking.transactionservice.model;
    import jakarta.persistence.*;
    import java.math.BigDecimal;

    @Entity
    @Table(name="bank_transactions")
    public class BankTransaction {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        private Long accountId;
private String type;
private BigDecimal amount;
private String status;
private String description;

        public BankTransaction() {}
        public BankTransaction(Long id, Long accountId, String type, BigDecimal amount, String status, String description) {
            this.id = id;
            this.accountId = accountId;
    this.type = type;
    this.amount = amount;
    this.status = status;
    this.description = description;
        }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public Long getAccountId() { return accountId; }
public void setAccountId(Long accountId) { this.accountId = accountId; }
public String getType() { return type; }
public void setType(String type) { this.type = type; }
public BigDecimal getAmount() { return amount; }
public void setAmount(BigDecimal amount) { this.amount = amount; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
    }
