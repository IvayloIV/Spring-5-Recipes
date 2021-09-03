package com.example.demo.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Animal {

    @NotNull
    @Size(min = 3, message = "{playerValidation.emptyAnimalName}")
    private String name;

    @NotNull(message = "{playerValidation.emptyAnimalType}")
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
