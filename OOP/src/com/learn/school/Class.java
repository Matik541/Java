package com.learn.school;

import java.util.*;

public class Class {
	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Teacher teacher;

	public Class(String name) {
		this.name = name;
	}
	public Class(String name, ArrayList<Student> students) {
		this.name = name;
		this.students = students;
	}
	public Class(String name, ArrayList<Student> students, Teacher teacher) {
		this.name = name;
		this.students = students;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * checks if student is in the class
	 * @param student student to check
	 * @return true if student is in the class
	 */
	private boolean checkStudents(Student student) {
		return students.contains(student);
	}

	/**
	 * Adds student to the class
	 * @param student Student to add to the class
	 */
	public void addStudent(Student student) {
		if (!checkStudents(student))
			students.add(student);
	}

	@Override
	public String toString() {
		StringBuilder retur = new StringBuilder("Class students=[ ");
		for (Student student : students) {
			retur.append(student.getName()).append(" ");
		}
		retur.append("]\n name='").append(name).append("', teacher=").append((teacher != null)?teacher.getName():null);
		return retur.toString();
	}
}
