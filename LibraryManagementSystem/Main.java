import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

public class Main {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.\n");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.\n");
            return;
        }
        System.out.println("\nID | Title | Author | Status");
        for (Book b : books) {
            System.out.printf("%d | %s | %s | %s%n", b.id, b.title, b.author,
                    b.issued ? "Issued" : "Available");
        }
        System.out.println();
    }

    static void issueBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id) {
                if (b.issued) System.out.println("Book is already issued.\n");
                else { b.issued = true; System.out.println("Book issued successfully.\n"); }
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    static void returnBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id) {
                b.issued = false;
                System.out.println("Book returned successfully.\n");
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    public static void main(String[] args) {
        books.add(new Book(101, "Clean Code", "Robert C. Martin"));
        books.add(new Book(102, "Effective Java", "Joshua Bloch"));

        while (true) {
            System.out.println("=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }
}
