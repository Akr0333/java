import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateGrossSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        return basicSalary + hra + da;
    }

    double calculateNetSalary() {
        double gross = calculateGrossSalary();
        double tax = gross * 0.05;
        return gross - tax;
    }
}

public class Main {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addEmployee() {
        System.out.print("Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Employee name: ");
        String name = sc.nextLine();
        System.out.print("Basic salary: ");
        double salary = sc.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully.\n");
    }

    static void showPayroll() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.\n");
            return;
        }
        System.out.println("\nID | Name | Basic | Gross | Net");
        for (Employee e : employees) {
            System.out.printf("%d | %s | %.2f | %.2f | %.2f%n",
                    e.id, e.name, e.basicSalary,
                    e.calculateGrossSalary(), e.calculateNetSalary());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        employees.add(new Employee(1, "Aarav", 40000));
        employees.add(new Employee(2, "Priya", 50000));

        while (true) {
            System.out.println("=== Employee Payroll System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Payroll");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> showPayroll();
                case 3 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }
}
