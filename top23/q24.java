import java.util.ArrayList;
import java.util.Scanner;

// Rentable interface
interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
}

// Car class implementing Rentable interface
class Car implements Rentable {
    private String licensePlate;
    private boolean isRented;
    private double dailyRate;

    public Car(String licensePlate, double dailyRate) {
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Car with license plate " + licensePlate + " has been rented.");
        } else {
            System.out.println("Car with license plate " + licensePlate + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Car with license plate " + licensePlate + " has been returned.");
        } else {
            System.out.println("Car with license plate " + licensePlate + " was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

// Motorcycle class implementing Rentable interface
class Motorcycle implements Rentable {
    private String licensePlate;
    private boolean isRented;
    private double dailyRate;

    public Motorcycle(String licensePlate, double dailyRate) {
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Motorcycle with license plate " + licensePlate + " has been rented.");
        } else {
            System.out.println("Motorcycle with license plate " + licensePlate + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Motorcycle with license plate " + licensePlate + " has been returned.");
        } else {
            System.out.println("Motorcycle with license plate " + licensePlate + " was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

// Bicycle class implementing Rentable interface
class Bicycle implements Rentable {
    private String serialNumber;
    private boolean isRented;
    private double dailyRate;

    public Bicycle(String serialNumber, double dailyRate) {
        this.serialNumber = serialNumber;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Bicycle with serial number " + serialNumber + " has been rented.");
        } else {
            System.out.println("Bicycle with serial number " + serialNumber + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bicycle with serial number " + serialNumber + " has been returned.");
        } else {
            System.out.println("Bicycle with serial number " + serialNumber + " was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

// RentalManager class to handle renting and returning vehicles
class RentalManager {
    private ArrayList<Rentable> vehicles;

    public RentalManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            vehicles.get(index).rent();
        } else {
            System.out.println("Invalid vehicle index.");
        }
    }

    public void returnVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            vehicles.get(index).returnVehicle();
        } else {
            System.out.println("Invalid vehicle index.");
        }
    }

    public void calculateRentalCost(int index, int days) {
        if (index >= 0 && index < vehicles.size()) {
            double cost = vehicles.get(index).calculateRentalCost(days);
            System.out.println("The rental cost for " + days + " days is: " + cost);
        } else {
            System.out.println("Invalid vehicle index.");
        }
    }

    public void displayVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            Rentable vehicle = vehicles.get(i);
            System.out.println(i + ": " + vehicle.getClass().getSimpleName());
        }
    }
}

// Main class to demonstrate the vehicle rental system
public class q24 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();

        // Adding some vehicles to the rental manager
        rentalManager.addVehicle(new Car("ABC123", 50));
        rentalManager.addVehicle(new Motorcycle("XYZ789", 30));
        rentalManager.addVehicle(new Bicycle("BIKE001", 10));

        while (true) {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Display vehicles");
            System.out.println("2. Rent a vehicle");
            System.out.println("3. Return a vehicle");
            System.out.println("4. Calculate rental cost");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rentalManager.displayVehicles();
                    break;
                case 2:
                    System.out.print("Enter vehicle index to rent: ");
                    int rentIndex = scanner.nextInt();
                    rentalManager.rentVehicle(rentIndex);
                    break;
                case 3:
                    System.out.print("Enter vehicle index to return: ");
                    int returnIndex = scanner.nextInt();
                    rentalManager.returnVehicle(returnIndex);
                    break;
                case 4:
                    System.out.print("Enter vehicle index to calculate cost: ");
                    int costIndex = scanner.nextInt();
                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();
                    rentalManager.calculateRentalCost(costIndex, days);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
