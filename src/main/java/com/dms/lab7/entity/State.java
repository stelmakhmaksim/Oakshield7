package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private TypeProcess typeProcess;
    @ManyToOne
    @JoinColumn
    private TypeState typeState;
    @ManyToOne
    @JoinColumn
    private Funct funct;
    private Boolean begin;
}
