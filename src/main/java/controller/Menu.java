package controller;

import entity.Book;
import entity.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner input;
    Library library;
    Registration registration;

    public Menu(Registration registration) {
        this.registration = registration;
        library = new Library();
        input = new Scanner(System.in);

    }

    public void showLibraryMenu() {
        String userInput;

        do {
            System.out.println("Please choose activity: \n" +
                    "1. Add New Book" + "\n" +
                    "2. View All Books" + "\n" +
                    "3. Find Book by Author" + "\n" +
                    "4. Take Out Books" + "\n" +
                    "5. View Available Books" + "\n" +
                    "6. Return Books" + "\n" +
                    "7. Delete Book" + "\n" +
                    "8. List of library readers" + "\n" +
                    "9. Exit the program.");

            System.out.println();
            System.out.print("Enter your choice: ");

            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    addBook();
                    break;
                case "2":
                    viewAllBooks();
                    break;
                case "3":
                    findBook();
                    break;
                case "4":
                    takeOutBooks();
                    break;
                case "5":
                    viewAvailableBooks();
                    break;
//                case "6":
//                    returnBooks();
//                    break;
                case "7":
                    deleteBook();
                    break;
                case "8":
                    showAllReaders();
                    break;
                case "9":
                    System.out.println("Existing LIBRARY.");
                    break;

                default:
                    break;
            }

        } while (!userInput.equalsIgnoreCase("9"));

        return;
    }

    void viewAllBooks() {
        ArrayList<Book> allBooks = library.getAllBooks();

        System.out.println("ALL BOOKS IN LIBRARY");
        System.out.printf("%-4s%-28s%-15s%-9s%n", "№", "Book title", "Book Author", "№ of Copy");

        int counter = 1;
        for (Book book: allBooks) {
            System.out.print(counter + ".  " + book.getFullBookInfo());
            counter++;
        }
        int count = library.bookCounting();
        System.out.println("There are " + count + " books in the library");
        System.out.println();
    }

    void addBook() {

        System.out.println("ADD NEW BOOK:");
        
        System.out.print("Enter Book Title: ");
        String title = input.nextLine();

        System.out.print("Enter Book Author: ");
        String author = input.nextLine();

        System.out.print("Enter № of Copy: ");
        int numberOfCopy = Integer.parseInt(input.nextLine());

        Book book = new Book(title, author, numberOfCopy);

        System.out.println(library.addBook(book) + "\n");

    }

    void findBook() {
        System.out.println("FIND BOOK BY AUTHOR");
        System.out.print("Enter Book Author Name: ");

        String bookAuthor = input.nextLine();
        var foundBooks = library.findBook(bookAuthor);
        System.out.printf("%-4s%-28s%-15s%-9s%n", "№", "Book title", "Book Author", "№ of Copy");
        if (foundBooks.size() == 0) {
            System.out.println("No book found");
        }
        int counter = 1;
        for (var fBook: foundBooks) {
            System.out.print(counter + ".  " + fBook.getFullBookInfo());
            counter++;
        }
//        System.out.print("If you want to take the book, enter its №: ");
//        int bookId = Integer.parseInt(input.nextLine());
//        var book = foundBooks.get(bookId-1);
//
//        book.setNumberOfCopy(book.getNumberOfCopy() -1);
    }

    void deleteBook() {
        System.out.println("DELETE BOOK");
        System.out.print("Enter Book ID: ");

        int bookId = Integer.parseInt(input.nextLine());

        String message;
        message = library.deleteBook(bookId);
        System.out.println(message + "\n");

        viewAllBooks();
    }

    void showAllReaders() {

        System.out.println("LIST of LIBRARY READERS");
        registration.getAllReaders();
        System.out.println();

    }

    void takeOutBooks() {
        System.out.println("BOOK SELECTION");
        System.out.print("Please Select a Book Author: ");

        String bookAuthor = input.nextLine();

        var noBooks = library.nonExistingBook(bookAuthor);
        var userChoiceOfBook = library.selectExistingBook(bookAuthor);

        if (!noBooks.isEmpty() && !userChoiceOfBook.isEmpty()) {
            System.out.println("Sorry, this book is not in the library: ");
            System.out.printf("%-4s%-28s%-15s%n", "№", "Book title", "Book Author");
            int counter = 1;
            for (var noBook: noBooks) {
                System.out.print(counter + ".  " + noBook.getFullBookInfo1());
                counter++;
            }
            System.out.println("\nYou can take out the following books: ");
            System.out.printf("%-4s%-28s%-15s%n", "№", "Book title", "Book Author");
            int counter1 = 1;
            for (var choiceOfBook: userChoiceOfBook) {
                System.out.print(counter1 + ".  " + choiceOfBook.getFullBookInfo1());
                counter1++;
            }
        } else if (!noBooks.isEmpty()) {
            System.out.println("Sorry, this book is not in the library: ");
            System.out.printf("%-4s%-28s%-15s%n", "№", "Book title", "Book Author");
            int counter = 1;
            for (var noBook: noBooks) {
                System.out.print(counter + ".  " + noBook.getFullBookInfo1());
                counter++;
            }
        } else {
            System.out.println("You can take out the following books: ");
            System.out.printf("%-4s%-28s%-15s%n", "№", "Book title", "Book Author");
            int counter1 = 1;
            for (var choiceOfBook: userChoiceOfBook) {
                System.out.print(counter1 + ".  " + choiceOfBook.getFullBookInfo1());
                counter1++;
            }
        }
        System.out.println();
    }

    void viewAvailableBooks() {
        ArrayList<Book> allBooks = library.getAllBooks();

        System.out.println("ALL AVAILABLE BOOKS IN LIBRARY");
        System.out.printf("%-4s%-28s%-15s%-9s%n", "№", "Book title", "Book Author", "№ of Copy");
        int counter = 1;
        for (Book book: allBooks) {
            if (!(book.getNumberOfCopy() == 0)) {
                System.out.print(counter + ".  " + book.getFullBookInfo());
                counter++;
            }
        }
            int count = library.bookCounting();
            System.out.println("There are " + count + " books in the library");
            System.out.println();

    }
}
