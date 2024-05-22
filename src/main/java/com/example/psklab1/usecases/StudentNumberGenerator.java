package com.example.psklab1.usecases;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class StudentNumberGenerator implements Serializable {
    public String generateNumber() {
        System.out.println("Pradedamas studento numerio generavimas...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "SN-" + new Random().nextInt(10000);
    }
}
