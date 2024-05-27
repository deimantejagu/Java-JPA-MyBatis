package com.example.psklab1.usecases;

import com.example.psklab1.interfaces.LoggedInvocation;
import org.h2.command.ddl.CreateTable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateStudentNumber implements Serializable {
    @Inject
    StudentNumberGenerator studentNumberGenerator;
    private CompletableFuture<String> studentNumberGeneratorTask = null;

    @LoggedInvocation
    public String generateNewStudentNumber() {
//        throw new RuntimeException();
        studentNumberGeneratorTask = CompletableFuture.supplyAsync(() -> studentNumberGenerator.generateNumber());

        return "index.xhtml?faces-redirect=true";
    }

    public boolean isStudentNumberGeneratorRunning() {
        return studentNumberGeneratorTask != null && !studentNumberGeneratorTask.isDone();
    }
}
