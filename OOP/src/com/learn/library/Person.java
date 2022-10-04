package com.learn.library;

public class Person {
	private String name;
	private String surname;
	private String birthDate;

	public Person(String name, String surname, String birthDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public String getName() { return name; }
	public String getSurname() { return surname; }
	public String getBirthDate() { return birthDate; }

	public void setName(String name) { this.name = name; }
	public void setSurname(String surname) { this.surname = surname; }
	public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

	@Override
	public String toString() {
		return "[\"" + name + " " + surname + "\" : " + birthDate + "]";
	}
}
