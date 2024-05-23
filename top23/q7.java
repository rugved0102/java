import java.util.Scanner;

// Interface for shapes that can be drawn
interface Drawable {
    void draw();
}

// Interface for shapes that can be resized
interface Resizable {
    void resize(double factor);
}

// Circle class implementing both Drawable and Resizable interfaces
class Circle implements Drawable, Resizable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resizing the circle. New radius: " + radius);
    }
}

// Rectangle class implementing the Drawable interface
class Rectangle implements Drawable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length " + length + " and width " + width);
    }
}

public class q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter radius of the circle: ");
            double radius = scanner.nextDouble();
            Circle circle = new Circle(radius);

            System.out.println("\nDrawing the circle:");
            circle.draw();

            System.out.print("\nEnter resizing factor for the circle: ");
            double factor = scanner.nextDouble();
            circle.resize(factor);
        } else if (choice == 2) {
            System.out.print("Enter length of the rectangle: ");
            double length = scanner.nextDouble();
            System.out.print("Enter width of the rectangle: ");
            double width = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(length, width);

            System.out.println("\nDrawing the rectangle:");
            rectangle.draw();
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
// 1
// 5
// 1.5
