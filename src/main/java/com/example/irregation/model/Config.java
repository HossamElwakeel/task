package com.example.irregation.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Config")
@Getter
@Setter
public class Config {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "land_id")
    private Land land;


    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="Num_irr")
    private int Num_irr;
}

