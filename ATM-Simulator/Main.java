import java.util.Scanner;

class Account {
    private double balance;
    private final int pin;

    Account(double openingBalance, int pin) {
        this.balance = openingBalance;
        this.pin = pin;
    }

    boolean verifyPin(int enteredPin) { return enteredPin == pin; }
    double getBalance() { return balance; }

    boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }
}

public class Main {
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account(25000.00, 1234);

        System.out.println("╔════════════════════════════╗");
        System.out.println("║       ATM SIMULATOR       ║");
        System.out.println("╚════════════════════════════╝");

        boolean authenticated = false;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();
            if (account.verifyPin(pin)) {
                authenticated = true;
                break;
            }
            System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempt));
        }

        if (!authenticated) {
            System.out.println("Account locked. Access denied.");
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.printf("Current balance: ₹%.2f%n", account.getBalance());
                case 2 -> {
                    System.out.print("Deposit amount: ₹");
                    double amount = sc.nextDouble();
                    System.out.println(account.deposit(amount) ? "Deposit successful." : "Invalid amount.");
                }
                case 3 -> {
                    System.out.print("Withdrawal amount: ₹");
                    double amount = sc.nextDouble();
                    System.out.println(account.withdraw(amount)
                            ? "Withdrawal successful."
                            : "Invalid amount or insufficient balance.");
                }
                case 4 -> {
                    System.out.println("Thank you for using the ATM.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }
}
