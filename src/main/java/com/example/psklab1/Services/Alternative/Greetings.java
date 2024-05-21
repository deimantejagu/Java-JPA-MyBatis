package com.example.psklab1.Services.Alternative;

import com.example.psklab1.interfaces.GreetingService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Greetings {
    @Inject
    private GreetingService greetingService;

    @Setter
    @Getter
    private String name;
    @Getter
    private String greeting;

    public void generateGreeting() {
        greeting = greetingService.greet(name);
    }
}
