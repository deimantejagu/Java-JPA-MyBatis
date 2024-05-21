package com.example.psklab1.Services.Specializes;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;

@RequestScoped
@Specializes
public class OptimisticLockErrorMessageHandler extends DefaultErrorMessageHandler {
    @Override
    public String getErrorMessage() {
        return "Update failed due to concurrent modification. Please try again.";
    }
}

