import java.util.Scanner;

class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) throws InvalidTemperatureException {
        if (celsius < -273.15 || celsius > 1000) {
            throw new InvalidTemperatureException("Invalid temperature value. Temperature must be within the range of -273.15°C to 1000°C.");
        }
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) throws InvalidTemperatureException {
        if (fahrenheit < -459.67 || fahrenheit > 1832) {
            throw new InvalidTemperatureException("Invalid temperature value. Temperature must be within the range of -459.67°F to 1832°F.");
        }
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        try {
            if (choice == 1) {
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
                System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");
            } else if (choice == 2) {
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double celsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
                System.out.println(fahrenheit + "°F is equal to " + celsius + "°C");
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (InvalidTemperatureException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
