package com.example.psklab1.Services.Alternative;

import com.example.psklab1.interfaces.GreetingService;

public abstract class GreetingDecorator implements  GreetingService{
    protected GreetingService decoratedGreetingService;

    public GreetingDecorator(GreetingService greetingService) {
        this.decoratedGreetingService = greetingService;
    }
}
