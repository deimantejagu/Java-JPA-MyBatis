package com.example.psklab1.persistence;

import com.example.psklab1.entities.StudentGroup;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudentGroupDAO {
    @Inject
    private EntityManager entityManager;

    public List<StudentGroup> loadAll() {
        return entityManager.createNamedQuery("StudentGroup.findAll", StudentGroup.class).getResultList();
    }

    public void persist(StudentGroup studentGroup){
        this.entityManager.persist(studentGroup);
    }

    public StudentGroup findOne(Long id) {
        return entityManager.find(StudentGroup.class, id);
    }
}
