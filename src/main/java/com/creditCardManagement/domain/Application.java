package com.creditCardManagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private String ssn;
    private LocalDate applicationDate;
    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
    private Account account;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    public Application(String applicantName, String ssn, LocalDate applicationDate, Status status) {
        this.applicantName = applicantName;
        this.ssn = ssn;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    // getters and setters
}
