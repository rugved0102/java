import java.util.Scanner;

class AdditionThread extends Thread {
    private final double num1, num2;

    public AdditionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println("Addition: " + (num1 + num2));
    }
}

class SubtractionThread extends Thread {
    private final double num1, num2;

    public SubtractionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println("Subtraction: " + (num1 - num2));
    }
}

class MultiplicationThread extends Thread {
    private final double num1, num2;

    public MultiplicationThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println("Multiplication: " + (num1 * num2));
    }
}

class DivisionThread extends Thread {
    private final double num1, num2;

    public DivisionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        if (num2 != 0) {
            System.out.println("Division: " + (num1 / num2));
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}

public class q17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();
            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();

            System.out.println("Choose an arithmetic operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new AdditionThread(num1, num2).start();
                    break;
                case 2:
                    new SubtractionThread(num1, num2).start();
                    break;
                case 3:
                    new MultiplicationThread(num1, num2).start();
                    break;
                case 4:
                    new DivisionThread(num1, num2).start();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            try {
                // Adding a delay to ensure all threads complete before the next iteration
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
