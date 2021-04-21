package controller;

import entity.Book;
import entity.Reader;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();

    public Library() {
        addDefaultBook();
    }

    public String addBook(Book newBook) {
        books.add(newBook);
        return "\nBook " + newBook.getTitle() + " created successfully";
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public String deleteBook(int bookId) {
        try {
            books.remove(bookId - 1);
        } catch (Exception ex) {
            return "Unable to remove specified book";
        }
        return "Book " + bookId + " removed successfully";
    }

    public ArrayList<Book> findBook(String bookAuthor) {

        ArrayList<Book> foundBooks = new ArrayList<>();

        for (Book book: books) {
            if (book.getAuthor().contains(bookAuthor)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void addDefaultBook() {

        addBook(new Book("Lord of the Ring. Part 1", "Tolkien", 1));
        addBook(new Book("Lord of the Ring. Part 2", "Tolkien", 2));
        addBook(new Book("Lord of the Ring. Part 3", "Tolkien", 3));
        addBook(new Book("The Law of Life", "London", 1));
        addBook(new Book("Sonnets", "Shakespeare", 0));
    }

    public int bookCounting() {
        int count = 0;
        for (Book book: books) {
            count = count + book.getNumberOfCopy();
        }
        return count;
    }

    public ArrayList<Book> selectExistingBook(String bookAuthor) {
        ArrayList<Book> userChoiceOfBook = new ArrayList<Book>();

        for (Book book: books) {
            if (book.getAuthor().contains(bookAuthor)) {
                if (!(book.getNumberOfCopy() == 0)) {
                    userChoiceOfBook.add(book);
                    book.setNumberOfCopy(book.getNumberOfCopy() - 1);
                }
            }
        }
        return userChoiceOfBook;
    }

    public ArrayList<Book> nonExistingBook(String bookAuthor) {
        ArrayList<Book> noBooks = new ArrayList<Book>();

        for (Book book: books) {
            if (book.getAuthor().contains(bookAuthor)) {
                if (book.getNumberOfCopy() == 0) {
                    noBooks.add(book);
                }
            }
        }
        return noBooks;
    }
}





