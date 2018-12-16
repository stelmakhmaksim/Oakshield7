package com.dms.lab7.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class GrPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private Set<Person> persons;
}
