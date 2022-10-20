package com.learn.school;

public class Uczestnik extends Person {
    private int founds;

    public Uczestnik(String name, String surname, int founds) {
        super(name, surname);
        this.founds = founds;
    }

    @Override
    public String toString() {
        return super.toString() + "founds: " + founds;
    }

    public int getFounds() {
        return founds;
    }

    public void changeFounds(int amount) {
        founds += amount;
    }
}
