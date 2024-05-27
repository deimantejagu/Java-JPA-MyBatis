package com.example.psklab1.usecases;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class StudentNumberGenerator implements Serializable {
    public String generateNumber() {
        System.out.println("Starting generate new student number...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread buvo pertrauktas");
            Thread.currentThread().interrupt();
        }

        String generatedStudentNumber = "SN-" + new Random().nextInt(2000);

        System.out.println("Generated student number: " + generatedStudentNumber);
        return generatedStudentNumber;
    }
}
