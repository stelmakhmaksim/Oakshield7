package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Predicat2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private TypeState state;
    @ManyToOne
    @JoinColumn
    private TypeDecision decision;
}
