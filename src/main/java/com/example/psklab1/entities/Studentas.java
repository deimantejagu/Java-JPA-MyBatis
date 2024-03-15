package com.example.psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Studentas {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String vardas;

    @Basic(optional = false)
    private String pavarde;

    @ManyToOne
    private Grupe grupe;

    @ManyToMany
    private List<PasirenkamasKursas> pasirenkamiKursai;
}
