import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the Java Calculator!");

        try (Scanner input = new Scanner(System.in)) {
            while (running) {
            System.out.print("Enter an operation (+, -, *, /, or exit): ");
            String op = input.nextLine();

            if (op.equals("exit")) {
                System.out.println("Exiting the calculator.");
                break;
            }

            if (!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))) {
                System.out.println("Invalid operation.");
                continue;
            }

            double num1;
            double num2;

            // Get first number with validation
            try {
                System.out.print("Enter the first number: ");
                num1 = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number.");
                continue;
            }

            if (num1 < -1000 || num1 > 1000) {
                System.out.println("Number must be between -1000 and 1000.");
                continue;
            }

            // Get second number with validation
            try {
                System.out.print("Enter the second number: ");
                num2 = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number.");
                continue;
            }

            if (num2 < -1000 || num2 > 1000) {
                System.out.println("Number must be between -1000 and 1000.");
                continue;
            }

            // Check for division by zero
            if (op.equals("/") && num2 == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                continue;
            }

            // Do the math
            double result;
            result = switch (op) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> num1 / num2;
                default -> {
                    throw new IllegalStateException("Unexpected value: " + op);
                }
            };

            // Show the result
            System.out.println("Result: " + result);

            // Ask if they want to continue
            System.out.print("Would you like to preform another operation? (yes/no): ");
            String again = input.nextLine();

            if (!again.equalsIgnoreCase("yes")) {
                running = false;
                System.out.println("Thank you for using Java Calculator! Goodbye!");
            }
        }

        }
    }
}