package com.example.psklab1.persistence;

import com.example.psklab1.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StudentsDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(Student student){
        this.entityManager.persist(student);
    }

    public Student findOne(Long id){
        return entityManager.find(Student.class, id);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }
}
