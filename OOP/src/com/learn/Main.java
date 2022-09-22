package com.learn;
public class Main {
	public static void main(String[] args) {

		Person John = new Person("John", 30);
		John.sayHello();
		System.out.println(John);


		Student Jane = new Student("Jane", 20, "A");
		Jane.sayHello();
		System.out.println(Jane);

	}
}