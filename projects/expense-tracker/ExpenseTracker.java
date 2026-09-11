import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    static class Expense {
        String category;
        double amount;

        Expense(String category, double amount) {
            this.category = category;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add expense\n2. List expenses\n3. Total\n4. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if (amount < 0) {
                        System.out.println("Amount must be positive.");
                    } else {
                        expenses.add(new Expense(category, amount));
                        System.out.println("Expense added.");
                    }
                }
                case "2" -> {
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        expenses.forEach(e -> System.out.printf("%-15s %.2f%n", e.category, e.amount));
                    }
                }
                case "3" -> {
                    double total = expenses.stream().mapToDouble(e -> e.amount).sum();
                    System.out.printf("Total spending: %.2f%n", total);
                }
                case "4" -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
