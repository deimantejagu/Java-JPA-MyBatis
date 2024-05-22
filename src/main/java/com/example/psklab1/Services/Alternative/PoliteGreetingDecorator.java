package com.example.psklab1.Services.Alternative;

import com.example.psklab1.interfaces.GreetingService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class PoliteGreetingDecorator extends GreetingDecorator{
    @Inject
    public PoliteGreetingDecorator(@Delegate GreetingService greetingService) {
        super(greetingService);
    }

    @Override
    public String greet(String name) {
        return decoratedGreetingService.greet(name) + ", have a nice day!";
    }
}
