# Quick Start Guide - The Coding Library

## Running the Application

### Method 1: Run the JAR File (Recommended)
```bash
java -jar TheCodingLibrary.jar
```

### Method 2: Run from Source (GUI)
```bash
java LibraryGUI
```

### Method 3: Run from Source (Command Line)
```bash
java LibraryManager
```

## What You'll See

The GUI application will open with:
- A table showing 6 pre-loaded programming books
- Input fields for ISBN, Title, and Author
- Buttons to Add Book, Check Out, Check In, and Refresh
- A message log area showing your actions

## Try These Actions

1. **Check Out a Book**: Click on any "Available" book in the table, then click "Check Out"
2. **Check In a Book**: Click on a "Checked Out" book, then click "Check In"
3. **Add a New Book**: Fill in all three fields (ISBN, Title, Author) and click "Add Book"

## If You Have Issues

- Make sure you have Java 8 or higher installed: `java -version`
- If the JAR doesn't run, compile and run from source
- On macOS, you may need to allow the app in Security & Privacy settings

## Project Files

- `Book.java` (1.6K) - Book object model
- `LibraryCatalog.java` (2.4K) - Catalog management with ArrayList
- `LibraryManager.java` (5.4K) - Command-line interface
- `LibraryGUI.java` (11K) - Graphical user interface
- `TheCodingLibrary.jar` (12K) - Executable application

## Building from Source

If you want to rebuild the JAR file:

```bash
# On macOS/Linux
./build-jar.sh

# On Windows (manually)
javac *.java
jar cfm TheCodingLibrary.jar manifest.txt *.class
```

## Support

For questions or issues, contact the project team through GitHub.
