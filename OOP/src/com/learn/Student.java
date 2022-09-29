package com.learn;

import java.util.*;

public class Student extends Person {
	private int nrOfStudent;
	public static int countOfStudents;

	public Student(String name, int age) {
//        wywolanie konstruktora klasy bazowej(rodzica)
		super(name, age);

		countOfStudents++;
		this.nrOfStudent = countOfStudents;
	}

	//    override nadpisanie istniejacej metody
	@Override
	public String toString() {
		return "Student " +
						" imie=" + getName() +
						" wiek=" + getAge() +
						" nrOfStudent=" + nrOfStudent;
	}
}