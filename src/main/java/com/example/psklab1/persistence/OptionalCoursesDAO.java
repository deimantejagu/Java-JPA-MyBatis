package com.example.psklab1.persistence;

import com.example.psklab1.entities.OptionalCourse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@ApplicationScoped
public class OptionalCoursesDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(OptionalCourse optionalCourse){
        this.entityManager.persist(optionalCourse);
    }

    public Optional<OptionalCourse> findByName(String name) {
        try {
            return Optional.of(entityManager.createQuery("SELECT oc FROM OptionalCourse oc WHERE oc.name = :name", OptionalCourse.class)
                    .setParameter("name", name)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public OptionalCourse findOne(Long courseId) {
        return entityManager.find(OptionalCourse.class, courseId);
    }
}
