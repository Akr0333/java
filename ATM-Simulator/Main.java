import java.util.Scanner;

public class Main {
    private static double balance = 25000.00;
    private static final int PIN = 1234;

    static boolean authenticate(Scanner sc) {
        System.out.print("Enter PIN: ");
        return sc.nextInt() == PIN;
    }

    static void checkBalance() {
        System.out.printf("Current balance: ₹%.2f%n", balance);
    }

    static void deposit(Scanner sc) {
        System.out.print("Enter deposit amount: ₹");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful.");
    }

    static void withdraw(Scanner sc) {
        System.out.print("Enter withdrawal amount: ₹");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== ATM Simulator ===");

        if (!authenticate(sc)) {
            System.out.println("Invalid PIN. Access denied.");
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit(sc);
                case 3 -> withdraw(sc);
                case 4 -> {
                    System.out.println("Thank you for using the ATM.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
