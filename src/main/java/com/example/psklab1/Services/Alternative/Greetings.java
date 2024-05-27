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
    // Čia CDI automatiškai injektiuos tinkamą dekoratorių, jei jis yra konfigūruotas
    private GreetingService greetingService;

    @Setter
    @Getter
    private String name;
    @Getter
    private String greeting;

    public void generateGreeting() {
        // Bus naudojamas dekoruotas pasisveikinimas, jei dekoratorius yra aktyvuotas
        greeting = greetingService.greet(name);
    }
}
