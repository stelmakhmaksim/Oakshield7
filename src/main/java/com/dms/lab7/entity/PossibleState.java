package com.dms.lab7.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class PossibleState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = {@JoinColumn(name = "TypeState"), @JoinColumn(name ="TypeDecision")})
    private Predicat2 predicat2;

    @ManyToOne
    @JoinColumn
    private TypeState typeState;
}
