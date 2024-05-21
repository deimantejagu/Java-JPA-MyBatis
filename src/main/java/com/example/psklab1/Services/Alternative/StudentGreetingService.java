package com.example.psklab1.Services.Alternative;

import com.example.psklab1.interfaces.GreetingService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello Student, " + name;
    }
}