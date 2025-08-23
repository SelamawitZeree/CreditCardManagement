package com.creditCardManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private double balance;
    private LocalDate openedDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "application_id")
    private Application application;

   @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

   @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Payment> payments;

    public enum Status {
        ACTIVE, CLOSED, SUSPENDED
    }

    public Account(double balance, String accountNumber, LocalDate openedDate, Status status) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.openedDate = openedDate;
        this.status = status;
    }

    // getters and setters
}
