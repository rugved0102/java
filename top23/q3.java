import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
    abstract void displayDetails();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    void displayDetails() {
        System.out.println("Rectangle Details:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    void displayDetails() {
        System.out.println("Triangle Details:");
        System.out.println("Side 1: " + side1);
        System.out.println("Side 2: " + side2);
        System.out.println("Side 3: " + side3);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    Shape circle = new Circle(radius);
                    circle.displayDetails();
                    break;
                case 2:
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    Shape rectangle = new Rectangle(length, width);
                    rectangle.displayDetails();
                    break;
                case 3:
                    System.out.print("Enter side 1: ");
                    double side1 = scanner.nextDouble();
                    System.out.print("Enter side 2: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Enter side 3: ");
                    double side3 = scanner.nextDouble();
                    Shape triangle = new Triangle(side1, side2, side3);
                    triangle.displayDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

// 1
// 5
// 2
// 4
// 6
// 3
// 3
// 4
