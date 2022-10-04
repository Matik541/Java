package com.learn.library;

import java.util.ArrayList;

public class Library {
	private static final Library library = new Library();

	private static ArrayList<Reader> readers = new ArrayList<Reader>();
	private static ArrayList<Book> books = new ArrayList<Book>();
	private static ArrayList<Librarian> librarians = new ArrayList<Librarian>();

	private Library() {}
	public static Library getInstance() { return library;	}

	public static ArrayList<Book> getBooks() { return books; }
	public static ArrayList<Reader> getReaders() { return readers; }
	public static ArrayList<Librarian> getLibrarians() { return librarians; }


	public static void addBook(String title, Person author) {
		books.add(new Book(title, author));
		System.out.println("Book \"" + title + "\" added to library");
	}

	public static void addReader(Person person) {
		readers.add(new Reader(person.getName(), person.getSurname(), person.getBirthDate()));
		System.out.println("Reader " + person.getName() + " " + person.getSurname() + " added to library");
	}

	public static void addLibrarian(Person person, String dateOfEmployment) {
		librarians.add(new Librarian(person.getName(), person.getSurname(), person.getBirthDate(), dateOfEmployment));
		System.out.println("Librarian " + person.getName() + " " + person.getSurname() + " added to library");
	}
}
