package com.creditCardManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private Method method;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public enum Method {
        CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER
    }

    public Payment(Double amount, LocalDateTime paymentDate, Method method) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
    }
// getters and setters
}
