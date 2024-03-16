package com.example.psklab1.persistence;

import com.example.psklab1.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StudentDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(Student student){
        this.entityManager.persist(student);
    }

    public Student findOne(Integer id){
        return entityManager.find(Student.class, id);
    }

    public Student update(Student student){
        return entityManager.merge(student);
    }
}
