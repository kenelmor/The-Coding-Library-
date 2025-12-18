//Project Name: The Coding Library
//Author: Ryan Roberts
//Date: 12/5/2025
//This class provides the main interface for users to interact with the library system.

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<Book> bookCollection;
    private Scanner scanner;

    // Constructor
    public LibraryManager() {
        this.bookCollection = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add books to the collection (for testing/setup)
    public void addBook(Book book) {
        bookCollection.add(book);
    }

    // Main menu display
    public void displayMenu() {
        System.out.println("\n========== The Coding Library ==========");
        System.out.println("1. Check Out a Book");
        System.out.println("2. Check In a Book");
        System.out.println("3. Check Book Status");
        System.out.println("4. View All Books");
        System.out.println("5. Exit");
        System.out.println("========================================");
        System.out.print("Please select an option (1-5): ");
    }

    // Method to check out a book
    public void checkOutBook() {
        System.out.print("\nEnter the ISBN of the book to check out: ");
        String isbn = scanner.nextLine();
        
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            if (!book.isOut()) {
                book.checkoutBook();
            } else {
                System.out.println("Sorry, this book is already checked out.");
            }
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    // Method to check in a book
    public void checkInBook() {
        System.out.print("\nEnter the ISBN of the book to check in: ");
        String isbn = scanner.nextLine();
        
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            book.checkinBook();
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    // Method to check the status of a book
    public void checkBookStatus() {
        System.out.print("\nEnter the ISBN of the book to check: ");
        String isbn = scanner.nextLine();
        
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            System.out.println("\n--- Book Status ---");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Status: " + (book.isOut() ? "Checked Out" : "Available"));
            System.out.println("-------------------");
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    // Method to view all books in the collection
    public void viewAllBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("\nThe library is currently empty.");
            return;
        }
        
        System.out.println("\n========== All Books in Library ==========");
        for (int i = 0; i < bookCollection.size(); i++) {
            Book book = bookCollection.get(i);
            System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + 
                             " (ISBN: " + book.getIsbn() + ") - " + 
                             (book.isOut() ? "Checked Out" : "Available"));
        }
        System.out.println("==========================================");
    }

    // Helper method to find a book by ISBN
    private Book findBookByIsbn(String isbn) {
        for (Book book : bookCollection) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Main run method for the library system
    public void run() {
        System.out.println("Welcome to The Coding Library!");
        System.out.println("Your resource for programming books.\n");
        
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    checkOutBook();
                    break;
                case "2":
                    checkInBook();
                    break;
                case "3":
                    checkBookStatus();
                    break;
                case "4":
                    viewAllBooks();
                    break;
                case "5":
                    System.out.println("\nThank you for using The Coding Library. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid option. Please select 1-5.");
            }
        }
        
        scanner.close();
    }

    // Main method for testing
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        
        // Sample books for testing
        library.addBook(new Book("Java Programming", "John Smith", "ISBN001"));
        library.addBook(new Book("Python Basics", "Jane Doe", "ISBN002"));
        library.addBook(new Book("JavaScript Essentials", "Bob Johnson", "ISBN003"));
        library.addBook(new Book("C++ Fundamentals", "Alice Williams", "ISBN004"));
        
        // Run the library system
        library.run();
    }
}
