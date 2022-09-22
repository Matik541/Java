package com.learn;

public class Student extends Person {

	private static int studentID;
	private String grade;

	public Student(String name, int age, String grade) {
		super(name, age);
		this.grade = grade;
		studentID++;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String toString() {
		return "Student [grade=" + grade + ", name=" + getName() + ", age=" + getAge() + "]";
	}
}
