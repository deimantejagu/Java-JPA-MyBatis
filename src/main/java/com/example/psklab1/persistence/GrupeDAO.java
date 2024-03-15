package com.example.psklab1.persistence;

import com.example.psklab1.entities.Grupe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GrupeDAO {
    @Inject
    private EntityManager entityManager;

    public void createGrupe(Grupe grupe) {
        entityManager.persist(grupe);
    }
    public List<Grupe> loadGrupes() {
        return entityManager.createNamedQuery("Grupe.loadGrupes", Grupe.class).getResultList();
    }

    public Grupe findOne(Long id){
        return entityManager.find(Grupe.class, id);
    }
}
