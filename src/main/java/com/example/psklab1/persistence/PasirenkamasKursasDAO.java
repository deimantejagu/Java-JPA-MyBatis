package com.example.psklab1.persistence;

import com.example.psklab1.entities.PasirenkamasKursas;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class PasirenkamasKursasDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(PasirenkamasKursas pasirenkamasKursas){
        this.entityManager.persist(pasirenkamasKursas);
    }

    public PasirenkamasKursas update(PasirenkamasKursas pasirenkamasKursas){
        return entityManager.merge(pasirenkamasKursas);
    }
}
