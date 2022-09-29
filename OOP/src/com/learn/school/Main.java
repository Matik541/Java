package com.learn.school;

public class Main {
	public static void main(String[] args) {
//        brak modyfikatora dostepu dostep wewnatrz pakietu
//        nie mozemy tworzyc person, bo jest klasa abstrakcyjna
//        protekted wewnatrz klasy dziedzikow i paketu
//        w konstruktorze klasy potomnej super piwinien byc pierwszym
		Student janek = new Student("Jas", 15);
		Student ela = new Student("Ela", 14);
		Student basia = new Student("Basia", 15);
		Student antek = new Student("Antek", 15);
		Student cecylia = new Student("Cecylia", 16);

		System.out.println(janek);
		System.out.println(cecylia);

		Teacher symon = new HeadTeacher("Szymon", 26, "przedmioty zawodowe", "P1");

		System.out.println(symon);

		Class classP1 = new Class("P1");

		System.out.println(classP1);

		School school = School.getInstance();

		school.addStudentToClass(janek, classP1);
		school.addStudentToClass(ela, classP1);
		school.addStudentToClass(basia, classP1);
		school.addStudentToClass(antek, classP1);
		school.addStudentToClass(cecylia, classP1);

		school.addTeacherToClass(symon, classP1);

		System.out.println(classP1);
	}
}