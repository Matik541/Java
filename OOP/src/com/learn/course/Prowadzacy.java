package com.learn.school;

import java.util.ArrayList;

public final class Prowadzacy extends Person {
    private String skills;


    public Prowadzacy(String name, String surname, String skills) {
        super(name, surname);
        this.skills = skills;
        System.out.println("Created new Prowadzący: { " + this + " } ");
    }

    @Override
    public String toString() {
        return super.toString() + "skills: " + skills;
    }
}
