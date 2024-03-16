package com.example.psklab1.persistence;

import com.example.psklab1.entities.OptionalCourse;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class OptionalCourseDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(OptionalCourse optionalCourse){
        this.entityManager.persist(optionalCourse);
    }

    public OptionalCourse update(OptionalCourse optionalCourse){
        return entityManager.merge(optionalCourse);
    }
}
