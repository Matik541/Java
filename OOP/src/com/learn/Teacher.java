package com.learn;

import java.util.*;

public sealed class Teacher extends Person permits HeadTeacher {
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
}