package com.learn;

import java.util.*;

public class Main {
	public static void main(String[] args) {
//        brak modyfikatora dostepu dostep wewnatrz pakietu
//        nie mozemy tworzyc person, bo jest klasa abstrakcyjna
//        protekted wewnatrz klasy dziedzikow i paketu
//        w konstruktorze klasy potomnej super piwinien byc pierwszym
		Student janek = new Student("Jas", 11);

		System.out.println(janek);

		Teacher teacher = new HeadTeacher("Name", 22, "przedmioty zawodowe", "3A");

		System.out.println(teacher);
	}
}