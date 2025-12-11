//Project Name: The Coding Library
//Author: Trinity Young
//Date: 12/11/2025
//This class handles taking the book objects and placing them in an ArrayList,
//which also informs the user if the book is checked out or not.

import java.util.ArrayList;

public class BookCollection {
    private ArrayList<Book> books;

    // Constructor
    public BookCollection() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the collection
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' has been added to the library.");
    }

    // Method to remove a book from the collection
    public void removeBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            books.remove(book);
            System.out.println("Book '" + book.getTitle() + "' has been removed from the library.");
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    // Method to find a book by ISBN
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Method to find books by title (partial match)
    public ArrayList<Book> findBooksByTitle(String title) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // Method to get all books
    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Method to get all available books
    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isOut()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // Method to get all checked out books
    public ArrayList<Book> getCheckedOutBooks() {
        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isOut()) {
                checkedOutBooks.add(book);
            }
        }
        return checkedOutBooks;
    }

    // Method to display all books with their status
    public void displayAllBooksWithStatus() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }

        System.out.println("\n========== Library Collection ==========");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String status = book.isOut() ? "CHECKED OUT" : "AVAILABLE";
            System.out.println((i + 1) + ". " + book.getTitle() + 
                             " by " + book.getAuthor() + 
                             " (ISBN: " + book.getIsbn() + ") - " + status);
        }
        System.out.println("========================================");
    }

    // Method to display available books only
    public void displayAvailableBooks() {
        ArrayList<Book> availableBooks = getAvailableBooks();
        
        if (availableBooks.isEmpty()) {
            System.out.println("No books are currently available.");
            return;
        }

        System.out.println("\n========== Available Books ==========");
        for (int i = 0; i < availableBooks.size(); i++) {
            Book book = availableBooks.get(i);
            System.out.println((i + 1) + ". " + book.getTitle() + 
                             " by " + book.getAuthor() + 
                             " (ISBN: " + book.getIsbn() + ")");
        }
        System.out.println("=====================================");
    }

    // Method to get the total number of books
    public int getTotalBooks() {
        return books.size();
    }

    // Method to get the number of available books
    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    // Method to get the number of checked out books
    public int getCheckedOutBooksCount() {
        return getCheckedOutBooks().size();
    }

    // Method to display library statistics
    public void displayStatistics() {
        System.out.println("\n========== Library Statistics ==========");
        System.out.println("Total Books: " + getTotalBooks());
        System.out.println("Available Books: " + getAvailableBooksCount());
        System.out.println("Checked Out Books: " + getCheckedOutBooksCount());
        System.out.println("========================================");
    }
}
