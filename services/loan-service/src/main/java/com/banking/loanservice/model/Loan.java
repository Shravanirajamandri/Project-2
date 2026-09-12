package com.banking.loanservice.model;
    import jakarta.persistence.*;
    import java.math.BigDecimal;

    @Entity
    @Table(name="loans")
    public class Loan {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        private Long customerId;
private String loanType;
private BigDecimal amount;
private String status;

        public Loan() {}
        public Loan(Long id, Long customerId, String loanType, BigDecimal amount, String status) {
            this.id = id;
            this.customerId = customerId;
    this.loanType = loanType;
    this.amount = amount;
    this.status = status;
        }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public Long getCustomerId() { return customerId; }
public void setCustomerId(Long customerId) { this.customerId = customerId; }
public String getLoanType() { return loanType; }
public void setLoanType(String loanType) { this.loanType = loanType; }
public BigDecimal getAmount() { return amount; }
public void setAmount(BigDecimal amount) { this.amount = amount; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
    }
