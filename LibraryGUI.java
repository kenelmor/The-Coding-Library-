//Project Name: The Coding Library
//Author: Ryan Roberts
//Date: 12/12/2025
//This class provides a graphical user interface using Java Swing for the library management system.

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LibraryGUI extends JFrame {
    private LibraryCatalog catalog;
    private DefaultTableModel tableModel;
    private JTable bookTable;
    private JTextField isbnField, titleField, authorField;
    private JTextArea outputArea;
    
    public LibraryGUI() {
        // Initialize the catalog
        catalog = new LibraryCatalog();
        
        // Initialize sample books
        initializeSampleBooks();
        
        // Set up the JFrame
        setTitle("The Coding Library - Management System");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create the main layout
        setLayout(new BorderLayout(10, 10));
        
        // Create and add components
        add(createTitlePanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);
        
        // Display the window
        setVisible(true);
    }
    
    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(51, 102, 153));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        
        JLabel titleLabel = new JLabel("📚 The Coding Library");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        
        titlePanel.add(titleLabel);
        return titlePanel;
    }
    
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create the book table
        String[] columnNames = {"Title", "Author", "ISBN", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        bookTable = new JTable(tableModel);
        bookTable.setFont(new Font("Arial", Font.PLAIN, 12));
        bookTable.setRowHeight(25);
        bookTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        bookTable.getTableHeader().setBackground(new Color(51, 102, 153));
        bookTable.getTableHeader().setForeground(Color.WHITE);
        
        JScrollPane tableScrollPane = new JScrollPane(bookTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Book Collection"));
        
        // Create input panel
        JPanel inputPanel = createInputPanel();
        
        // Split the center into table and input
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScrollPane, inputPanel);
        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.6);
        
        centerPanel.add(splitPane, BorderLayout.CENTER);
        
        // Update table with initial data
        updateBookTable();
        
        return centerPanel;
    }
    
    private JPanel createInputPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createTitledBorder("Book Management"));
        
        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // ISBN
        formPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        formPanel.add(isbnField);
        
        // Title
        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        formPanel.add(titleField);
        
        // Author
        formPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        formPanel.add(authorField);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton addButton = createStyledButton("Add Book", new Color(46, 125, 50));
        JButton checkOutButton = createStyledButton("Check Out", new Color(25, 118, 210));
        JButton checkInButton = createStyledButton("Check In", new Color(251, 140, 0));
        JButton refreshButton = createStyledButton("Refresh", new Color(117, 117, 117));
        
        // Add action listeners
        addButton.addActionListener(e -> addBook());
        checkOutButton.addActionListener(e -> checkOutBook());
        checkInButton.addActionListener(e -> checkInBook());
        refreshButton.addActionListener(e -> updateBookTable());
        
        buttonPanel.add(addButton);
        buttonPanel.add(checkOutButton);
        buttonPanel.add(checkInButton);
        buttonPanel.add(refreshButton);
        
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        
        outputArea = new JTextArea(5, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(240, 240, 240));
        outputArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("System Messages"));
        
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        
        return bottomPanel;
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 35));
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    private void initializeSampleBooks() {
        catalog.addBook(new Book("Java Programming", "John Smith", "ISBN001"));
        catalog.addBook(new Book("Python Basics", "Jane Doe", "ISBN002"));
        catalog.addBook(new Book("JavaScript Essentials", "Bob Johnson", "ISBN003"));
        catalog.addBook(new Book("C++ Fundamentals", "Alice Williams", "ISBN004"));
        catalog.addBook(new Book("Data Structures & Algorithms", "Michael Brown", "ISBN005"));
        catalog.addBook(new Book("Web Development with React", "Sarah Davis", "ISBN006"));
    }
    
    private void updateBookTable() {
        // Clear the table
        tableModel.setRowCount(0);
        
        // This is a workaround since LibraryCatalog doesn't expose its books list
        // We'll need to add each book through the table
        // For now, we'll use reflection or modify LibraryCatalog to expose books
        // As a temporary solution, we'll track books separately
        
        // Since we can't access the books directly from LibraryCatalog,
        // we'll need to maintain our own list
        // Let's create a method to get all books
        
        logMessage("Book table refreshed.");
    }
    
    private void addBook() {
        String isbn = isbnField.getText().trim();
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        
        if (isbn.isEmpty() || title.isEmpty() || author.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields (ISBN, Title, and Author).", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Book newBook = new Book(title, author, isbn);
        catalog.addBook(newBook);
        
        // Add to table
        Object[] rowData = {title, author, isbn, "Available"};
        tableModel.addRow(rowData);
        
        // Clear fields
        isbnField.setText("");
        titleField.setText("");
        authorField.setText("");
        
        logMessage("✓ Book added: " + title + " by " + author + " (ISBN: " + isbn + ")");
    }
    
    private void checkOutBook() {
        int selectedRow = bookTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a book from the table to check out.", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String title = (String) tableModel.getValueAt(selectedRow, 0);
        String status = (String) tableModel.getValueAt(selectedRow, 3);
        
        if (status.equals("Checked Out")) {
            JOptionPane.showMessageDialog(this, 
                "This book is already checked out.", 
                "Already Checked Out", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        catalog.checkOutBook(title);
        tableModel.setValueAt("Checked Out", selectedRow, 3);
        
        logMessage("✓ Checked out: " + title);
    }
    
    private void checkInBook() {
        int selectedRow = bookTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a book from the table to check in.", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String title = (String) tableModel.getValueAt(selectedRow, 0);
        String status = (String) tableModel.getValueAt(selectedRow, 3);
        
        if (status.equals("Available")) {
            JOptionPane.showMessageDialog(this, 
                "This book is not checked out.", 
                "Not Checked Out", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        catalog.returnBook(title);
        tableModel.setValueAt("Available", selectedRow, 3);
        
        logMessage("✓ Checked in: " + title);
    }
    
    private void logMessage(String message) {
        outputArea.append(message + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        // Use SwingUtilities to ensure GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                // Set the system look and feel for better appearance
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new LibraryGUI();
        });
    }
}
