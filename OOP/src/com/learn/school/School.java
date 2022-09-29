package com.learn.school;

import java.util.ArrayList;

public class School {

	private static final School school = new School();
	private ArrayList<Class> classes = new ArrayList<Class>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();

	private School() {}

	public static School getInstance() {
		return school;
	}
	public void addStudentToClass(Student student, Class clas) {
		if (!classes.contains(clas))
			classes.add(clas);

		if (!students.contains(student))
			students.add(student);

		if (!teachers.contains(clas.getTeacher()))
			teachers.add(clas.getTeacher());

		clas.addStudent(student);
		System.out.println("Student " + student.getName() + " added to class " + clas.getName());
	}

	public void addTeacherToClass(Teacher teacher, Class clas) {
		if (!classes.contains(clas))
			classes.add(clas);

		if (!teachers.contains(teacher))
			teachers.add(teacher);

		clas.setTeacher(teacher);
		System.out.println("Teacher " + teacher.getName() + " added to class " + clas.getName());
	}
}
