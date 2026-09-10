import java.util.Scanner;

class BankAccount {
    private String holder;
    private double balance;

    BankAccount(String holder, double initialBalance) {
        this.holder = holder;
        this.balance = Math.max(0, initialBalance);
    }

    void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
    }

    void showBalance() {
        System.out.printf("Account holder: %s%nBalance: ₹%.2f%n", holder, balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double initial = sc.nextDouble();
        BankAccount account = new BankAccount(name, initial);

        while (true) {
            System.out.println("\n=== Banking Management System ===");
            System.out.println("1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Amount: ");
                        account.deposit(sc.nextDouble());
                        System.out.println("Deposit successful.");
                    }
                    case 2 -> {
                        System.out.print("Amount: ");
                        account.withdraw(sc.nextDouble());
                        System.out.println("Withdrawal successful.");
                    }
                    case 3 -> account.showBalance();
                    case 4 -> {
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
