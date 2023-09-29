package com.example.demo2608.model;

import com.example.demo2608.model.type.Attach_service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract_detail{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "id")
    Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false, referencedColumnName = "id")
    Attach_service attachService;

    @Column(name = "quantity")
    private int quantity;
}
