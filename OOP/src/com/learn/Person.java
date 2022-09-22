package com.learn;

public class Person {
	private String name;
	private int age;

	// Constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// ToString
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	// getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	//setter
	public void setName(String name) {
		if (name.length() > 3 && name.matches("[A-Z][a-z]{2,}"))
			this.name = name;
	}

	public void setAge(int age) {
		if (age > this.age && age < 100)
			this.age = age;
	}


	// method
	public void sayHello() {
		System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
	}
}
