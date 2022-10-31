package com.example.irregation.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Land")
public class Land {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;

    @Column(name="area")
    private Double area;


    @Column(name="location")
    private String location;

    @Column(name="type_of_soil")
    private String typeOfSoil;

    public Land() {

    }

    public Land(Double area, String location, String type_of_soil) {
        this.area = area;
        this.location = location;
        this.typeOfSoil = type_of_soil;
    }


}
