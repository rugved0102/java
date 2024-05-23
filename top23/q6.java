import java.util.Scanner;

public class q6 {
    private static final double PI;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        PI = 3.14;
        System.out.println("Welcome to the Simple Calculator!");
    }

    {
        System.out.println("New calculator instance");
    }

    public q6() {
        // Default constructor
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        q6 calculator = new q6();

        while (true) {
            // Perform calculations
            System.out.println("Choose operation:");
            System.out.println("A. Addition");
            System.out.println("B. Subtraction");
            System.out.println("C. Multiplication");
            System.out.println("D. Division");
            System.out.println("E. Exit");
            System.out.print("Enter your choice: ");
            char choice = scanner.next().charAt(0);

            if (choice == 'E') {
                System.out.println("Exiting calculator...");
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = 0;

            switch (choice) {
                case 'A':
                    result = add(num1, num2);
                    break;
                case 'B':
                    result = subtract(num1, num2);
                    break;
                case 'C':
                    result = multiply(num1, num2);
                    break;
                case 'D':
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue; // Restart the loop if choice is invalid
            }

            System.out.println("Result: " + result);

            // Print the value of PI
            System.out.println("Value of PI: " + PI);
        }

        scanner.close();
    }
}
