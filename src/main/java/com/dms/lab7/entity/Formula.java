package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Funct funct;
    @ManyToOne
    @JoinColumn
    private Predicat2 predicat2;
    private Integer dis;
    private Integer con;
}
