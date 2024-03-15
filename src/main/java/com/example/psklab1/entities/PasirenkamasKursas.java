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
public class PasirenkamasKursas {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String pavadinimas;

    @ManyToMany(mappedBy = "pasirenkamiKursai")
    private List<Studentas> studentai;
}
