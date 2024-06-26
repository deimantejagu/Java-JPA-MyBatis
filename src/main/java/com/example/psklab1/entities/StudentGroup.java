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

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version = 0;

    @OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
}
