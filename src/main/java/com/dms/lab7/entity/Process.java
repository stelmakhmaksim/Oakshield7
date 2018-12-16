package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn
    private TypeProcess TypePr;
    @ManyToOne
    @JoinColumn
    private Prod prod;
}
