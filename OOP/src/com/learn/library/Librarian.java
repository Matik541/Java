package com.learn.library;

public class Librarian extends Person {
	private String employeeDate;

	public Librarian(String name, String surname, String birthDate, String employeeDate) {
		super(name, surname, birthDate);
		this.employeeDate = employeeDate;
	}

	public String getEmployeeDate() { return employeeDate; }
	public void setEmployeeDate(String employeeDate) { this.employeeDate = employeeDate; }

	@Override
	public String toString() {
		return "[\"" + getName() + " " + getSurname() + "\" *: " + getBirthDate() + ", employed: " + employeeDate + "]";
	}

}
