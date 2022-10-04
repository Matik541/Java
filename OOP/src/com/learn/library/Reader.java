package com.learn.library;

import java.util.ArrayList;

public class Reader extends Person {
	private int id;
	private ArrayList<Book> borrows;

	public Reader(String name, String surname, String birthDate) {
		super(name, surname, birthDate);
		this.id = (Library.getReaders().size() + 1);
		this.borrows = new ArrayList<Book>();
	}

	public int getId() {
		return id;
	}

	public ArrayList<Book> getBorrows() {
		return borrows;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[\"" + getName() + " " + getSurname() + "\" *: " + getBirthDate() + ", id: " + id + "]";
	}

	public void borrowBook(Book book) {
		if (book.isBorrowed()) {
			System.out.println("Book \"" + book.getTitle() + "\" is already borrowed");
		} else {
			book.setBorrowed(true);
			borrows.add(book);
			System.out.println("Book \"" + book.getTitle() + "\" borrowed by " + getName() + " " + getSurname());
		}
	}

	public void returnBook(Book book) {
		if (!book.isBorrowed()) {
			System.out.println("Book \"" + book.getTitle() + "\" is not borrowed");

		} else if (!borrows.contains(book)) {
			System.out.println("Book \"" + book.getTitle() + "\" is not borrowed by " + getName() + " " + getSurname());

		} else {
			book.setBorrowed(false);
			borrows.remove(book);
			System.out.println("Book \"" + book.getTitle() + "\" returned by " + getName() + " " + getSurname());
		}
	}
}
