package com.example.demo.domain;

public class Player {

    private String name;

    private Integer age;

    private Pet pet;

    private Sport sport;

    public Player() {
    }

    public Player(String name, Integer age, Pet pet, Sport sport) {
        this.name = name;
        this.age = age;
        this.pet = pet;
        this.sport = sport;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
