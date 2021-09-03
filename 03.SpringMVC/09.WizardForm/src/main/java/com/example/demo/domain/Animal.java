package com.example.demo.domain;

public class Animal {

    private String name;

    private AnimalType animalType;

    public Animal() {
    }

    public Animal(String name, AnimalType animalType) {
        this.name = name;
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }
}
