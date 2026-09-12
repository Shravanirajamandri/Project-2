package com.banking.paymentservice.model;
    import jakarta.persistence.*;
    import java.math.BigDecimal;

    @Entity
    @Table(name="payments")
    public class Payment {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        private Long customerId;
private String paymentType;
private BigDecimal amount;
private String status;
private String description;

        public Payment() {}
        public Payment(Long id, Long customerId, String paymentType, BigDecimal amount, String status, String description) {
            this.id = id;
            this.customerId = customerId;
    this.paymentType = paymentType;
    this.amount = amount;
    this.status = status;
    this.description = description;
        }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public Long getCustomerId() { return customerId; }
public void setCustomerId(Long customerId) { this.customerId = customerId; }
public String getPaymentType() { return paymentType; }
public void setPaymentType(String paymentType) { this.paymentType = paymentType; }
public BigDecimal getAmount() { return amount; }
public void setAmount(BigDecimal amount) { this.amount = amount; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
    }
