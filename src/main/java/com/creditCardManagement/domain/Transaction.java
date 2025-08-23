package com.creditCardManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String merchant;
    private Double amount;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public enum Type {
        PURCHASE, REFUND
    }

    public Transaction(String merchant, Double amount, LocalDateTime date, Type type) {
        this.merchant = merchant;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
// getters and setters
}
