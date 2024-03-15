package com.example.psklab1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NamedQuery(name = "Grupe.loadGrupes", query = "SELECT g FROM Grupe g")
public class Grupe {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String specialybe;

    @Basic(optional = false)
    private Integer kursas;

    @OneToMany(mappedBy = "grupe")
    private List<Studentas> studentai;
}
