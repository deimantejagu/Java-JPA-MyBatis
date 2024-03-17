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
@NamedQuery(name = "Student.findAll", query = "select s from Student as s")
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String lastName;

    @ManyToOne
    private StudentGroup studentGroup;

    @ManyToMany
    private List<OptionalCourse> optionalCourses;
}
