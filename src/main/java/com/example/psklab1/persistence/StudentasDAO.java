package com.example.psklab1.persistence;

import com.example.psklab1.entities.Studentas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StudentasDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(Studentas studentas){
        this.entityManager.persist(studentas);
    }

    public Studentas findOne(Integer id){
        return entityManager.find(Studentas.class, id);
    }

    public Studentas update(Studentas studentas){
        return entityManager.merge(studentas);
    }
}
