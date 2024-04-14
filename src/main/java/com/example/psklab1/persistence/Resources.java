package com.example.psklab1.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.SynchronizationType;

@ApplicationScoped
public class Resources {

//    Įterpia Entity manager objektą į aplikaciją
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    @Default
//    Objektas yra sukurtas naujai kiekvienai HTTP
//    užklausai ir išnyksta užklausai pasibaigus
    @RequestScoped
    private EntityManager createJTAEntityManager() {
        return emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
    }

//    @Dispose - skirtas išvalyti resursus, kuriuos naudoja aplikacija,
//    kai resursai nebebus reikalingi. Pavyzdžiui, uždaryti duomenų bazės ryšius
//    ar išvalyti laikinuosius failus, kurie buvo sukurti per aplikacijos veikimą.
    private void closeDefaultEntityManager(@Disposes @Default EntityManager em) {
        em.close();
    }
}
