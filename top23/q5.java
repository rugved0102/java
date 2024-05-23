import java.util.Scanner;

public class q5 {
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static double calculateArea(double side) {
        return side * side;
    }

    public static double calculateArea(double radius, boolean isCircle) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Area Calculator");
        System.out.println("Choose shape to calculate area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        double area = 0;

        switch (choice) {
            case 1:
                System.out.print("Enter length of rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter width of rectangle: ");
                double width = scanner.nextDouble();
                area = calculateArea(length, width);
                System.out.println("Area of rectangle: " + area);
                break;
            case 2:
                System.out.print("Enter side of square: ");
                double side = scanner.nextDouble();
                area = calculateArea(side);
                System.out.println("Area of square: " + area);
                break;
            case 3:
                System.out.print("Enter radius of circle: ");
                double radius = scanner.nextDouble();
                area = calculateArea(radius, true);
                System.out.println("Area of circle: " + area);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}

//2
//25