package com.learn.school;

import java.util.ArrayList;

public class Course {
    private String name;
    private Prowadzacy prowadzacy;
    private String description;
    private ArrayList<Uczestnik> uczestnicy = new ArrayList<Uczestnik>();
    private int price;

    public Course(String name, Prowadzacy prowadzacy, String description, int price) {
        this.name = name;
        this.prowadzacy = prowadzacy;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "'" + name + "', '" + description + "', price: " + price + ",\nprowadzący: " + prowadzacy + ",\nuczestnicy (" + uczestnicy.size() + "): " + uczestnicy;
    }

    public boolean addUczetnik(Uczestnik uczestnik) {
        if (uczestnicy.contains(uczestnik)) {
            System.out.println(uczestnik + " is already in this course!");
            return false;
        }
        if (uczestnicy.size() > 12) {
            System.out.println("No more slosts in this couse!");
            return false;
        }
        if (uczestnik.getFounds() < price) {
            System.out.println(uczestnik + " have no enough money, needed: " + price);
            return false;
        }
        uczestnik.changeFounds(-price);
        uczestnicy.add(uczestnik);
        System.out.println("Added " + uczestnik + ", to this cours!");
        return true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prowadzacy getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(Prowadzacy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Uczestnik> getUczestnicy() {
        return uczestnicy;
    }

    public void setUczestnicy(ArrayList<Uczestnik> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }

}
