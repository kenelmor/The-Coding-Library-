# The Coding Library 📚

A comprehensive library management system built with Java, featuring both graphical and command-line interfaces for managing a collection of programming books.

## 🎯 Project Overview

The Coding Library is a Java-based library management system that allows users to browse, check out, and return programming books. The project demonstrates object-oriented programming principles, GUI development with Java Swing, and the use of ArrayList data structures for collection management.

### Features
- **Dual Interface**: Full-featured GUI and command-line interface
- **Book Management**: Add, check out, and return books with real-time status tracking
- **Visual Table View**: Interactive JTable displaying all books with sortable columns
- **ArrayList Implementation**: Efficient collection management using Java Collections Framework
- **Pre-loaded Content**: Sample programming books covering Java, Python, JavaScript, C++, and more
- **User-Friendly Design**: Color-coded buttons, styled components, and clear system messages
- **Executable JAR**: Standalone application that runs without IDE

### Data Structures
This project uses **ArrayList<Book>** as its primary data structure to manage the book collection. The ArrayList provides:
- Dynamic resizing as books are added
- Fast iteration for displaying and searching books
- Efficient access by index for table operations
- Flexible collection management without fixed size constraints

## 👥 Contributors

This project is a collaborative effort by:
- **Kenneth Elmore** - Book Object Architecture & Core Data Model ([Book.java](Book.java))
- **Trinity Young** - Catalog & Collection Management with ArrayList Implementation ([LibraryCatalog.java](LibraryCatalog.java))
- **Ryan Roberts** - User Interfaces (CLI & GUI) & Main System Logic ([LibraryManager.java](LibraryManager.java), [LibraryGUI.java](LibraryGUI.java))

### External Resources
- Java Swing Documentation: [Oracle Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- All code was written by team members; no external tutorials were directly copied

## 🏗️ Project Architecture

### Core Classes

#### [Book.java](Book.java#L1-L60) (Author: Kenneth Elmore)
The foundation class that defines the Book object with all its properties and behaviors.

**Attributes:**
- `title` (String) - The book's title
- `author` (String) - The book's author
- `isbn` (String) - Unique identifier for the book
- `isOut` (boolean) - Checkout status

**Key Methods:**
- `getTitle()`, `getAuthor()`, `getIsbn()` - Accessor methods for book properties
- `checkoutBook()` - Marks book as checked out and displays confirmation
- `checkinBook()` - Marks book as returned and displays confirmation
- `isOut()`, `isCheckedOut()` - Returns the current checkout status
- `setCheckedOut(boolean)` - Updates checkout status (used by LibraryCatalog)
- `toString()` - Returns formatted string representation of the book

#### [LibraryCatalog.java](LibraryCatalog.java#L1-L90) (Author: Trinity Young)
Manages the collection of books using ArrayList and provides catalog operations.

**Data Structure:** `ArrayList<Book>` - Stores all books in the catalog

**Key Methods:**
- `addBook(Book)` - Adds a new book to the collection
- `listBooks()` - Prints all books with their availability status
- `checkOutBook(String title)` - Checks out a book by title
- `returnBook(String title)` - Returns a book by title
- `getBookStatus(String title)` - Displays the status of a specific book
- `getAllBooks()` - Returns a copy of the book collection
- `findBook(String title)` - Helper method to search for books by title

#### [LibraryManager.java](LibraryManager.java#L1-L130) (Author: Ryan Roberts)
Provides a command-line interface for interacting with the library system.

**Features:**
- Interactive menu-driven interface
- ISBN-based book operations
- Input validation with Scanner
- Pre-loaded sample data for testing

**Menu Options:**
1. Check Out a Book (by ISBN)
2. Check In a Book (by ISBN)
3. Check Book Status (by ISBN)
4. View All Books
5. Exit

**Key Methods:**
- `displayMenu()` - Shows the main menu
- `checkOutBook()` - Handles book checkout workflow
- `checkInBook()` - Handles book return workflow
- `checkBookStatus()` - Displays detailed book information
- `viewAllBooks()` - Lists entire catalog
- `findBookByIsbn(String)` - Searches for books by ISBN
- `run()` - Main application loop

#### [LibraryGUI.java](LibraryGUI.java#L1-L350) (Author: Ryan Roberts)
Provides a comprehensive graphical user interface using Java Swing.

**GUI Components:**
- **JTable** - Displays all books in a sortable, selectable table
- **JTextField** - Input fields for ISBN, Title, and Author
- **JButton** - Action buttons (Add, Check Out, Check In, Refresh)
- **JTextArea** - System message log
- **Custom Styling** - Color-coded buttons and professional layout

**Key Features:**
- Real-time table updates after each operation
- Click-to-select book interaction
- Error dialogs and validation messages
- Scroll panes for table and message log
- Split pane layout for optimal space usage
- macOS-specific optimizations

**Key Methods:**
- `createTitlePanel()` - Creates the branded header
- `createCenterPanel()` - Sets up the main content area with table and form
- `createInputFormPanel()` - Creates the book input form
- `createButtonPanel()` - Creates styled action buttons
- `createBottomPanel()` - Sets up the message log area
- `updateBookTable()` - Refreshes the table with current catalog data
- `addBook()` - Validates input and adds new books
- `checkOutBook()` - Handles book checkout from table selection
- `checkInBook()` - Handles book return from table selection
- `initializeSampleBooks()` - Loads initial book collection

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt

**Check your Java version:**
```bash
java -version
```

### Installation

1. **Clone the repository:**
```bash
git clone https://github.com/kenelmor/The-Coding-Library-.git
cd The-Coding-Library-
```

### Running the Application

#### Option 1: Run the JAR File (Recommended - Easiest)
```bash
java -jar TheCodingLibrary.jar
```
This launches the GUI application with all features.

#### Option 2: Run from Source (GUI)
```bash
# Compile if needed
javac Book.java LibraryCatalog.java LibraryManager.java LibraryGUI.java

# Run the GUI
java LibraryGUI
```

#### Option 3: Run from Source (Command-Line Interface)
```bash
# Compile if needed
javac Book.java LibraryCatalog.java LibraryManager.java

# Run the CLI
java LibraryManager
```

### Building the JAR File

To create your own executable JAR file:

#### Method 1: Use the Build Script (macOS/Linux)
```bash
chmod +x build-jar.sh
./build-jar.sh
```

#### Method 2: Manual Build
```bash
# Compile all Java files
javac Book.java LibraryCatalog.java LibraryManager.java LibraryGUI.java

# Create the JAR with manifest
jar cfm TheCodingLibrary.jar manifest.txt *.class

# Run the JAR
java -jar TheCodingLibrary.jar
```

The [manifest.txt](manifest.txt) file specifies `LibraryGUI` as the main class that launches on startup.

## 📖 Usage Guide

### Using the GUI (LibraryGUI)

When you run the GUI application, you'll see a window with three main sections:

#### 1. Book Collection Table (Top)
- Displays all books with columns: Title, Author, ISBN, and Status
- Click on any row to select a book
- Shows real-time availability ("Available" or "Checked Out")

#### 2. Book Management Form (Middle)
Input fields for managing books:
- **ISBN**: Unique identifier for the book
- **Title**: Book's title
- **Author**: Book's author

Action buttons:
- **Add Book** (Green) - Adds a new book using the form data
- **Check Out** (Blue) - Checks out the selected book from the table
- **Check In** (Orange) - Returns the selected book to the library
- **Refresh** (Gray) - Manually refreshes the table display

#### 3. System Messages (Bottom)
- Shows confirmation messages for all actions
- Logs book additions, checkouts, and returns
- Displays error messages and validation warnings

#### Common Workflows:

**To check out a book:**
1. Click on an available book in the table
2. Click the "Check Out" button
3. Confirmation appears in the message log

**To return a book:**
1. Click on a checked-out book in the table
2. Click the "Check In" button
3. Status updates to "Available"

**To add a new book:**
1. Fill in all three fields (ISBN, Title, Author)
2. Click "Add Book"
3. New book appears in the table
4. Form fields clear automatically

### Using the Command-Line Interface (LibraryManager)

When you run `java LibraryManager`, you'll see an interactive menu:

```
========== The Coding Library ==========
1. Check Out a Book
2. Check In a Book
3. Check Book Status
4. View All Books
5. Exit
========================================
```

**Menu Options:**
- **1. Check Out a Book** - Enter ISBN to borrow a book
- **2. Check In a Book** - Enter ISBN to return a book
- **3. Check Book Status** - View details of a specific book by ISBN
- **4. View All Books** - Display the entire catalog with status
- **5. Exit** - Close the application

**Example Session:**
```bash
Please select an option (1-5): 4
[Views all books with their current status]

Please select an option (1-5): 1
Enter the ISBN of the book to check out: ISBN001
You have taken out: Java Programming

Please select an option (1-5): 3
Enter the ISBN of the book to check: ISBN001
Status: Checked Out
```

## � Sample Books

The application comes pre-loaded with six programming books for demonstration:

| ISBN | Title | Author |
|------|-------|--------|
| ISBN001 | Java Programming | John Smith |
| ISBN002 | Python Basics | Jane Doe |
| ISBN003 | JavaScript Essentials | Bob Johnson |
| ISBN004 | C++ Fundamentals | Alice Williams |
| ISBN005 | Data Structures & Algorithms | Michael Brown |
| ISBN006 | Web Development with React | Sarah Davis |

These books are automatically added when the application starts, allowing you to immediately test checkout and return functionality.

## � Project Structure

```
The-Coding-Library-/
│
├── Book.java                    # Book object model (1.6 KB)
├── LibraryCatalog.java          # Catalog management with ArrayList (2.4 KB)
├── LibraryManager.java          # Command-line interface (5.4 KB)
├── LibraryGUI.java              # Graphical user interface (11 KB)
│
├── TheCodingLibrary.jar         # Executable JAR file (12 KB)
├── manifest.txt                 # JAR manifest specifying main class
├── build-jar.sh                 # Build script for creating JAR file
│
├── README.md                    # This file - comprehensive documentation
├── QUICKSTART.md                # Quick start guide
├── PROJECT_COMPLETION.md        # Project requirements checklist
│
└── media/                       # Screenshots and media assets
    └── README.md                # Instructions for taking screenshots
```

### File Descriptions

- **Book.java** - Core Book class with properties and methods
- **LibraryCatalog.java** - ArrayList-based collection manager
- **LibraryManager.java** - CLI application with menu system
- **LibraryGUI.java** - Full Swing GUI application
- **TheCodingLibrary.jar** - Standalone executable
- **build-jar.sh** - Automated build script (macOS/Linux)
- **manifest.txt** - Specifies LibraryGUI as main entry point

## 🎓 Learning Outcomes

This project demonstrates key computer science concepts:

### Object-Oriented Programming
- **Encapsulation**: Private fields with public getter/setter methods in Book class
- **Abstraction**: Clear separation between Book, Catalog, and UI classes
- **Class Design**: Well-defined responsibilities for each class
- **Object Composition**: LibraryCatalog contains ArrayList of Book objects

### Data Structures
- **ArrayList Implementation**: Dynamic collection management
- **Iteration**: Enhanced for-loops and traditional iteration over collections
- **Search Algorithms**: Linear search for finding books by ISBN or title

### User Interface Development
- **GUI Programming**: Java Swing components and event handling
- **Event-Driven Architecture**: ActionListeners for button clicks
- **Layout Management**: BorderLayout, GridBagLayout, FlowLayout
- **User Experience**: Input validation, error messages, visual feedback

### Software Engineering
- **Team Collaboration**: Three contributors with clear responsibilities
- **Version Control**: Git and GitHub for source code management
- **Documentation**: Comprehensive README and inline code comments
- **Build Automation**: Shell script for JAR creation
- **Code Organization**: Modular design with reusable components

## 🔧 Development Status

**Current Phase**: ✅ **Complete - Ready for Submission**

**Completed Features:**
- ✅ Four Java classes with proper documentation headers
- ✅ ArrayList<Book> data structure implementation
- ✅ Full-featured GUI with Java Swing
- ✅ Command-line interface alternative
- ✅ Check-out and return functionality
- ✅ Real-time status tracking
- ✅ Executable JAR file with manifest
- ✅ Build automation script
- ✅ Comprehensive documentation

**Future Enhancements** (beyond project scope):
- File I/O for persistent data storage
- Database integration (SQL or NoSQL)
- User authentication and profiles
- Advanced search with filters
- Due dates and late fee calculation
- Book reservations and holds
- Email notifications
- Book recommendations

## 🐛 Troubleshooting

### JAR File Won't Run
```bash
# Check Java version (need 8 or higher)
java -version

# Try running with explicit classpath
java -cp TheCodingLibrary.jar LibraryGUI

# On macOS, check Security & Privacy settings
# System Preferences → Security & Privacy → Allow apps
```

### Compilation Errors
```bash
# Make sure all files are present
ls *.java

# Clean and recompile
rm *.class
javac Book.java LibraryCatalog.java LibraryManager.java LibraryGUI.java
```

### GUI Not Appearing
- Ensure you're running LibraryGUI (not LibraryManager)
- Check that DISPLAY is set (Linux)
- Verify Java has GUI support (some server JDKs don't)
- Try: `java -Djava.awt.headless=false LibraryGUI`

## 🤝 Contributing

This is a student project for learning purposes. Team members contribute according to their assigned components. External contributions are welcome via pull requests.

## 📄 License

This project is created for educational purposes.

## 📧 Contact

For questions or suggestions, please contact the project contributors through their respective GitHub profiles. 
