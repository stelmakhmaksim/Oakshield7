package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AccessState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private TypeProcess typeProcess;
    @ManyToOne
    @JoinColumn
    private GrPerson grPerson;
    @ManyToOne
    @JoinColumn
    private State state;
}
