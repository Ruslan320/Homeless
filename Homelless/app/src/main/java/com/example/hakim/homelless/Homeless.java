package com.example.hakim.homelless;

import java.io.Serializable;

public class Homeless implements Serializable {
    private int capital;
    private int health;
    private int age;
    private String name;

    public Homeless(String name, int age){
        this.age = age;
        this.name = name;
        capital = 0;
        health = 100;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital += capital;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age += age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
