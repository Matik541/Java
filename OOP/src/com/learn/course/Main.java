package com.learn.school;

public class Main {
    public static void main(String[] args) {

        Prowadzacy prowadzacy1 = new Prowadzacy("Name1", "Surname1", "Java, C++, programowanie");
        Prowadzacy prowadzacy2 = new Prowadzacy("Name2", "Surname2", "Kulinaria, Gotowanie");

        System.out.println(prowadzacy1);
        System.out.println(prowadzacy2);

        Uczestnik uczestnikA = new Uczestnik("A", "Aaa", 150);
        Uczestnik uczestnikB = new Uczestnik("B", "Bbb", 50);
        Uczestnik uczestnikC = new Uczestnik("C", "Ccc", 550);

        System.out.println(uczestnikA);
        System.out.println(uczestnikB);
        System.out.println(uczestnikC);

        Course kursProgramowania = new Course("Kurs Programowania", prowadzacy1, "Poznaj tajemne praktyki programowania w Javie", 150);
        Course kursGotowania = new Course("Kurs Gotowanie", prowadzacy1, "Naucz się gotować już w 5dni z naszym kursem", 50);

        System.out.println(kursProgramowania);
        System.out.println(kursGotowania + "\n-----");

        kursGotowania.setProwadzacy(prowadzacy2);

        kursProgramowania.addUczetnik(uczestnikA);
        kursProgramowania.addUczetnik(uczestnikA);
        kursProgramowania.addUczetnik(uczestnikB);

        System.out.println("-----");

        kursGotowania.addUczetnik(uczestnikA);
        kursGotowania.addUczetnik(uczestnikB);
        kursGotowania.addUczetnik(uczestnikC);

        System.out.println("-----");

        System.out.println(kursProgramowania);
        System.out.println(kursGotowania);
    }
}