# The Coding Library 📚

A comprehensive library management system designed to help beginner and intermediate programmers discover and learn from programming books across various languages.

## 🎯 Project Overview

The Coding Library is a Java-based library management system that allows users to browse, check out, and return programming books. The project aims to create an intuitive interface for managing a collection of educational programming resources.

### Features
- Book catalog management with title, author, and ISBN tracking
- Check-out and return functionality
- Real-time availability status for all books
- **Graphical User Interface (GUI)** built with Java Swing
- Command-line interface option
- Search books by ISBN or title
- ArrayList-based data structure for efficient book management
- Interactive table view showing all books and their status

### Data Structures
This project uses **ArrayList** (a complex data structure from the Java Collections Framework) to manage the book collection efficiently. The ArrayList allows for dynamic resizing, fast lookups, and easy iteration through the book catalog.

## 👥 Contributors

This project is a collaborative effort by:
- **Kenneth Elmore** - Book Object Architecture & Core Data Model
- **Trinity Young** - Catalog & Collection Management with ArrayList Implementation
- **Ryan Roberts** - User Interfaces (CLI & GUI) & Main System Logic

### External Resources
- Java Swing Documentation: [Oracle Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- All code was written by team members; no external tutorials were directly copied

## 🏗️ Project Architecture

### Core Classes

#### `Book.java` (Author: Kenneth Elmore)
Handles the creation and management of individual book objects.
- **Attributes**: title, author, ISBN, checkout status
- **Methods**: 
  - Getters for all book properties
  - `checkoutBook()` - Marks book as checked out
  - `checkinBook()` - Marks book as returned
  - `isCheckedOut()` / `isOut()` - Check availability status
  - `setCheckedOut()` - Update checkout status

#### `LibraryCatalog.java` (Author: Trinity Young)
Manages the collection of books using an **ArrayList** (complex data structure) and provides status information.
- **Data Structure**: Uses `ArrayList<Book>` to store the book collection
- **Functionality**:
  - Add books to the catalog
  - List all books with their current status
  - Check out books by title
  - Return books by title
  - Query individual book status
  - Search and retrieval operations using iteration

#### `LibraryManager.java` (Author: Ryan Roberts)
Provides the command-line interface and interaction logic.
- **Features**:
  - Interactive menu system
  - Check out books by ISBN
  - Check in (return) books by ISBN
  - View status of specific books
  - Display all books in the collection
  - User input validation
  - Sample data initialization

#### `LibraryGUI.java` (Author: Ryan Roberts)
Provides a **graphical user interface** using Java Swing for intuitive interaction.
- **GUI Components**:
  - JTable for displaying all books in a sortable table
  - JTextField inputs for ISBN, Title, and Author
  - Styled JButtons for actions (Add, Check Out, Check In, Refresh)
  - JTextArea for system messages and logs
  - Custom color scheme and styling
- **Features**:
  - Visual book management interface
  - Click-to-select books from table
  - Real-time status updates
  - Error dialogs and confirmations
  - Pre-loaded with sample programming books

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- A Java IDE or text editor (recommended: IntelliJ IDEA, Eclipse, or VS Code)
- Terminal/Command prompt

### Installation & Running

#### Option 1: Run the JAR File (Easiest)
1. Clone the repository:
```bash
git clone https://github.com/kenelmor/The-Coding-Library-.git
cd The-Coding-Library-
```

2. Run the pre-built JAR file:
```bash
java -jar TheCodingLibrary.jar
```

#### Option 2: Compile from Source
1. Clone the repository (if not already done):
```bash
git clone https://github.com/kenelmor/The-Coding-Library-.git
cd The-Coding-Library-
```

2. Compile all Java files:
```bash
javac Book.java LibraryCatalog.java LibraryManager.java LibraryGUI.java
```

3. Run the **GUI version** (recommended):
```bash
java LibraryGUI
```

4. Or run the **command-line version**:
```bash
java LibraryManager
```

### Building the JAR File

To create your own executable JAR file:

1. First, create a manifest file (`manifest.txt`):
```
Main-Class: LibraryGUI
```

2. Compile all classes:
```bash
javac *.java
```

3. Create the JAR:
```bash
jar cfm TheCodingLibrary.jar manifest.txt *.class
```

4. Run the JAR:
```bash
java -jar TheCodingLibrary.jar
```

## 📖 Usage

### Using the GUI (LibraryGUI.java)

When you run `java LibraryGUI`, a graphical window will open with:

1. **Book Table**: Displays all books with their title, author, ISBN, and availability status
2. **Input Fields**: 
   - ISBN: Enter the book's unique identifier
   - Title: Enter the book's title
   - Author: Enter the book's author
3. **Action Buttons**:
   - **Add Book**: Add a new book to the library (fill all fields first)
   - **Check Out**: Select a book from the table and click to check it out
   - **Check In**: Select a checked-out book and click to return it
   - **Refresh**: Update the table display
4. **System Messages**: View confirmation messages and system logs at the bottom

#### GUI Workflow:
- To **check out** a book: Click on the book row in the table, then click "Check Out"
- To **return** a book: Click on a checked-out book, then click "Check In"
- To **add** a new book: Fill in ISBN, Title, and Author fields, then click "Add Book"

### Using the Command Line (LibraryManager.java)

When you run `java LibraryManager`, you'll see a text menu:

```
========== The Coding Library ==========
1. Check Out a Book
2. Check In a Book
3. Check Book Status
4. View All Books
5. Exit
========================================
```

- **Option 1**: Enter the ISBN of a book to check it out
- **Option 2**: Enter the ISBN of a book to return it
- **Option 3**: Check if a specific book is available or checked out
- **Option 4**: View the complete catalog with availability status
- **Option 5**: Exit the application

## 📝 Sample Books

The system comes pre-loaded with sample programming books:
- Java Programming by John Smith (ISBN001)
- Python Basics by Jane Doe (ISBN002)
- JavaScript Essentials by Bob Johnson (ISBN003)
- C++ Fundamentals by Alice Williams (ISBN004)
- Data Structures & Algorithms by Michael Brown (ISBN005)
- Web Development with React by Sarah Davis (ISBN006)

## 🔧 Development Status

**Current Phase**: ✅ **Project Complete - Ready for Submission**

**Completed Features**:
- ✅ Book object model with all required attributes and methods
- ✅ ArrayList-based catalog system (complex data structure requirement met)
- ✅ Check-out/check-in operations
- ✅ Status tracking and reporting
- ✅ Command-line interface (LibraryManager.java)
- ✅ **Graphical User Interface with Java Swing (LibraryGUI.java)**
- ✅ All classes have proper team name and author headers
- ✅ Integration of all core classes
- ✅ JAR file creation instructions
- ✅ Complete README documentation
- ✅ Screenshots ready for upload

**Future Enhancements** (beyond project scope):
- 📋 Persistent data storage (file I/O or database)
- 📋 User authentication system
- 📋 Advanced search by multiple criteria
- 📋 Due dates and late fees
- 📋 Book reservations

## 🤝 Contributing

This is a student project for learning purposes. Team members contribute according to their assigned components. External contributions are welcome via pull requests.

## 📄 License

This project is created for educational purposes.

## 📧 Contact

For questions or suggestions, please contact the project contributors through their respective GitHub profiles. 
