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
@NamedQuery(name = "StudentGroup.findAll", query = "SELECT g FROM StudentGroup g")
public class StudentGroup {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String specialty;

    @Basic(optional = false)
    private Integer course;

    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;
}
