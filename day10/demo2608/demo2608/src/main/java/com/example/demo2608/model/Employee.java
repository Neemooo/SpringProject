package com.example.demo2608.model;

import com.example.demo2608.model.type.Division;
import com.example.demo2608.model.type.Education;
import com.example.demo2608.model.type.Position;
import com.example.demo2608.model.type.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "id_card")
    private String id_card;

    @Column(name = "salary")
    private double salary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "id")
    Division division;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "id")
    Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "id")
    Education education;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false, referencedColumnName = "username")
    Users users;

}
