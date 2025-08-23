package com.creditCardManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportType;
    private LocalDate generatedDate;
    private String generatedBy;
    public Report(String reportType, LocalDate generatedDate, String generatedBy) {
        this.reportType = reportType;
        this.generatedDate = generatedDate;
        this.generatedBy = generatedBy;
    }

    // getters and setters
}
