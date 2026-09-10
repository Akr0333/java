import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
            "Which keyword creates an object in Java?",
            "Which collection stores unique elements?",
            "Which method is the entry point of a Java program?",
            "Which concept allows one class to acquire another class's properties?",
            "Which keyword is used for inheritance?"
        };
        String[][] options = {
            {"A. class", "B. new", "C. object", "D. create"},
            {"A. List", "B. ArrayList", "C. Set", "D. Map"},
            {"A. start()", "B. run()", "C. main()", "D. execute()"},
            {"A. Encapsulation", "B. Inheritance", "C. Abstraction", "D. Compilation"},
            {"A. implements", "B. inherits", "C. extends", "D. super"}
        };
        char[] answers = {'B', 'C', 'C', 'B', 'C'};
        int score = 0;

        System.out.println("=== Java Quiz Application ===");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQ" + (i + 1) + ". " + questions[i]);
            for (String option : options[i]) System.out.println(option);
            System.out.print("Your answer: ");
            char answer = Character.toUpperCase(sc.next().charAt(0));
            if (answer == answers[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. Correct answer: " + answers[i]);
            }
        }

        System.out.println("\nFinal Score: " + score + "/" + questions.length);
        System.out.println(score >= 4 ? "Excellent!" : score >= 3 ? "Good job!" : "Keep practising!");
        sc.close();
    }
}
