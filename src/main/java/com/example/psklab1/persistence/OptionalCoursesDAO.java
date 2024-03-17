package com.example.psklab1.persistence;

import com.example.psklab1.entities.OptionalCourse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@ApplicationScoped
public class OptionalCoursesDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(OptionalCourse optionalCourse){
        this.entityManager.persist(optionalCourse);
    }

    public OptionalCourse merge(OptionalCourse optionalCourse){
        return this.entityManager.merge(optionalCourse);
    }

    public void flush() {
        this.entityManager.flush();
    }
}
