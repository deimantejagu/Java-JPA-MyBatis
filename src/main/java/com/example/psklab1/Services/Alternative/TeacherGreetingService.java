package com.example.psklab1.Services.Alternative;

import com.example.psklab1.interfaces.GreetingService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class TeacherGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello Teacher, " + name;
    }
}