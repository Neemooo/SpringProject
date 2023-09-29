package com.example.demo2608.model;

import com.example.demo2608.model.type.Customer_type;
import com.example.demo2608.model.type.Division;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false, referencedColumnName = "id")
    Customer_type customerType;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "gender")
    private int gender;

    @Column(name = "id_card")
    private String id_card;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
}
