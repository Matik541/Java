package com.learn.library;

public class Book {
	private String title;
	private Person author;
	private boolean borrowed;

	public Book(String title, Person author) {
		this.title = title;
		this.author = author;
		this.borrowed = false;
	}

	public String getTitle() { return title; }
	public Person getAuthor() { return author; }
	public boolean isBorrowed() { return borrowed; }

	public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }

	@Override
	public String toString() {
		return "[\"" + title + "\", author:" + author.getName() + " " + author.getSurname() + ", borrowed: " + (((borrowed)?"yes":"no") + "]");
	}
}
