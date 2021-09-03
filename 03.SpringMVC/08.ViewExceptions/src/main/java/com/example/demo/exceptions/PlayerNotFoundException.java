package com.example.demo.exceptions;

public class PlayerNotFoundException extends Exception {

    private String name;

    public PlayerNotFoundException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
