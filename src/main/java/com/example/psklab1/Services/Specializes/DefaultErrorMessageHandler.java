package com.example.psklab1.Services.Specializes;
import javax.enterprise.context.RequestScoped;
import com.example.psklab1.interfaces.ErrorMessageHandler;

@RequestScoped
public class DefaultErrorMessageHandler implements ErrorMessageHandler {
    @Override
    public String getErrorMessage() {
        return "Error. PLease try again.";
    }
}
