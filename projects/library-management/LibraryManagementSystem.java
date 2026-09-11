import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    static class Book {
        int id;
        String title;
        String author;
        boolean borrowed;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }
    }

    static class Member {
        int id;
        String name;

        Member(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static final List<Book> books = new ArrayList<>();
    static final List<Member> members = new ArrayList<>();

    static Book findBook(int id) {
        for (Book book : books) if (book.id == id) return book;
        return null;
    }

    static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.printf("%d | %s | %s | %s%n", book.id, book.title, book.author,
                    book.borrowed ? "Borrowed" : "Available");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch"));

        while (true) {
            System.out.println("\n1. List books  2. Add book  3. Register member  4. Borrow  5. Return  6. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> listBooks();
                case "2" -> {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    books.add(new Book(id, title, author));
                    System.out.println("Book added.");
                }
                case "3" -> {
                    System.out.print("Member ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    members.add(new Member(id, name));
                    System.out.println("Member registered.");
                }
                case "4" -> {
                    System.out.print("Book ID: ");
                    Book book = findBook(Integer.parseInt(scanner.nextLine()));
                    if (book == null) System.out.println("Book not found.");
                    else if (book.borrowed) System.out.println("Book is already borrowed.");
                    else { book.borrowed = true; System.out.println("Book borrowed."); }
                }
                case "5" -> {
                    System.out.print("Book ID: ");
                    Book book = findBook(Integer.parseInt(scanner.nextLine()));
                    if (book == null) System.out.println("Book not found.");
                    else if (!book.borrowed) System.out.println("Book is already available.");
                    else { book.borrowed = false; System.out.println("Book returned."); }
                }
                case "6" -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
