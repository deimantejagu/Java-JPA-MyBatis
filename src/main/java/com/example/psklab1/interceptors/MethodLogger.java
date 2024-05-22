package com.example.psklab1.interceptors;

import com.example.psklab1.interfaces.LoggedInvocation;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable {
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        try {
            System.out.println("Called method: " + context.getMethod().getName());
            return context.proceed();
        } catch (Exception e) {
            System.out.println("Exception in method: " + context.getMethod().getName() + ": " + e.getMessage());
            throw  e;
        }

    }
}
