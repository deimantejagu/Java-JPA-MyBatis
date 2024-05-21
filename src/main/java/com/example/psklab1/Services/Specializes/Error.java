package com.example.psklab1.Services.Specializes;

import com.example.psklab1.interfaces.ErrorMessageHandler;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Error {

    @Inject
    private ErrorMessageHandler errorMessageHandler;

    public String getErrorMessage() {
        return errorMessageHandler.getErrorMessage();
    }
}