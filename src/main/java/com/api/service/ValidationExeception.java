package com.api.service;

public class ValidationExeception extends RuntimeException{
    public ValidationExeception(String message){
        super(message);
    }
}
