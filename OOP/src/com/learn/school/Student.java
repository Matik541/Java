package com.learn.school;

public class Student extends Person implements OnDuty {
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

	@Override
	public void DoDuty() {
		System.out.println("Student " + getName() + " is doing his duty" +
						"\nWhiteboard is clean" +
						"\nFLowers are watered");}
}