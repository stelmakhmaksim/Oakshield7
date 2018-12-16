package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private TypeProcess typeProcess;
    @ManyToOne
    @JoinColumn
    private State state;
    @ManyToOne
    @JoinColumn
    private TypeDecision typeDecision;
}
