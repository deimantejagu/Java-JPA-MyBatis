package com.example.psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class OptionalCourse {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "optionalCourses")
    private List<Student> students;

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.getOptionalCourses().add(this);
    }
}
