package com.learn.school;

public sealed class Teacher extends Person implements OnDuty  permits HeadTeacher {
	private String subject;
	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher " +
						" imie=" + getName() +
						" wiek=" + getAge() +
						" przedmiot=" + subject;
	}

	@Override
	public void DoDuty() {
		System.out.println("Teacher " + getName() + " is doing his duty" +
						"\nChecks the corridors" +
						"\nChecks the toilets" +
						"\nChecks the playground" );
	}
}