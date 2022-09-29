package com.learn.school;

public final class HeadTeacher extends Teacher {

	private String TeacherClass;
	public HeadTeacher(String name, int age, String subject, String TeacherClass) {
		super(name, age, subject);
		this.TeacherClass = TeacherClass;
	}

	public String getTeacherClass() {
		return TeacherClass;
	}

	public void setTeacherClass(String teacherClass) {
		TeacherClass = teacherClass;
	}

	@Override
	public String toString() {
		return "HeadTeacher " +
						" imie=" + getName() +
						" wiek=" + getAge() +
						" przedmiot=" + getSubject() +
						" klasa=" + TeacherClass;
	}
}