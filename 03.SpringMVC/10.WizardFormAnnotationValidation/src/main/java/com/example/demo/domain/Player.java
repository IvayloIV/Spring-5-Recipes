package com.example.demo.domain;

import com.example.demo.domain.validation.ValidationStepOne;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Player {

    @NotNull
    @Size(min = 3, message = "{playerValidation.emptyName}", groups = {ValidationStepOne.class})
    private String name;

    @Max(value = 100, message = "{playerValidation.maxAge}", groups = {ValidationStepOne.class})
    private Integer age;

    @Valid
    private Animal animal;

    public Player() {
    }

    public Player(String name, Integer age, Animal animal) {
        this.name = name;
        this.age = age;
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
