package com.example.demo2608.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attach_service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "cost")
    private double cost;

    @Column(name = "unit")
    private String unit;

    @Column(name = "status")
    private String status;
}
