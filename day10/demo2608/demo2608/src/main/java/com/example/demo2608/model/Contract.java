package com.example.demo2608.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Entity
@Table(name = "contract")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    biggernow
    @Column(name = "start_date")
    @FutureOrPresent
    private Timestamp start_date;

    @Column(name = "end_date")
    private Timestamp end_date;

    @Column(name = "deposit")
    @Min(0)
    private Double deposit;

    @Column(name = "total_money")
    private Double total_money;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "id")
    Service service;
}
