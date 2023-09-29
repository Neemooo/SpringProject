package com.example.demo2608.model;

import com.example.demo2608.model.type.Rent_type;
import com.example.demo2608.model.type.Service_type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "service")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private int area;

    @Column(name = "cost")
    private double cost;

    @Column(name = "max_people")
    private int max_people;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false, referencedColumnName = "id")
    Rent_type rent_type;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false, referencedColumnName = "id")
    Service_type service_type;

    @Column(name = "standard_room")
    private String standard_room;

    @Column(name = "other_convenience")
    private String other_convenience;

    @Column(name = "pool_area")
    private Double pool_area;

    @Column(name = "floors")
    private Integer floors;

    @Column(name = "free")
    private String free;
}
