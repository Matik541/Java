package com.learn.library;

public class Main {

  public static void main(String[] args) {

    Person danBrown = new Person("Dan", "Brown", "22.06.1964");
    Person adamMickiewicz = new Person("Adam", "Mickiewicz", "24.12.1798");

    Library.addBook("Pan Tadeusz", adamMickiewicz);
    Library.addBook("The Lost Symbol", danBrown);
    Library.addBook("The Da Vinci Code", danBrown);

    System.out.println("Books: " + Library.getBooks());

    Person janeDoe = new Person("Jane", "Doe", "02.02.2000");
    Person jackBlack = new Person("Jack", "Black", "01.01.2001");

    Library.addReader(new Person("John", "Smith", "01.01.2000"));
    Library.addReader(janeDoe);
    Library.addReader(jackBlack);

    System.out.println("Readers: " + Library.getReaders());

    Library.addLibrarian(janeDoe, "01.01.2010");
    Library.addLibrarian(jackBlack, "09.09.2015");

    System.out.println("Librarians: " + Library.getLibrarians());

    Library.getReaders().get(0).borrowBook(Library.getBooks().get(0));
    Library.getReaders().get(1).borrowBook(Library.getBooks().get(0));
    Library.getReaders().get(2).borrowBook(Library.getBooks().get(1));
    Library.getReaders().get(2).borrowBook(Library.getBooks().get(2));
    Library.getReaders().get(2).borrowBook(Library.getBooks().get(2));

    System.out.println("Borrowed by: " + Library.getReaders().get(2) + ": " + Library.getReaders().get(2).getBorrows());

    Library.getReaders().get(0).returnBook(Library.getBooks().get(2));
    Library.getReaders().get(2).returnBook(Library.getBooks().get(2));
    Library.getReaders().get(2).returnBook(Library.getBooks().get(2));
    Library.getReaders().get(0).returnBook(Library.getBooks().get(0));
  }
}