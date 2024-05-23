import java.util.ArrayList;
import java.util.Scanner;

// Abstract superclass Employee
abstract class Employee {
    protected String name;
    protected int employeeID;
    protected double salary;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public abstract void calculateSalary();

    public abstract void evaluatePerformance();
}

// Full-time employee subclass
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double performanceBonus;

    public FullTimeEmployee(String name, int employeeID, double monthlySalary, double performanceBonus) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public void calculateSalary() {
        this.salary = this.monthlySalary + this.performanceBonus;
    }

    @Override
    public void evaluatePerformance() {
        // Sample performance evaluation logic
        if (this.performanceBonus > 1000) {
            System.out.println("Excellent performance");
        } else {
            System.out.println("Satisfactory performance");
        }
    }
}

// Part-time employee subclass
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int employeeID, double hourlyRate, int hoursWorked) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculateSalary() {
        this.salary = this.hourlyRate * this.hoursWorked;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Performance evaluation not applicable for part-time employees");
    }
}

// Main class for the employee management system
public class q15 {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int nextEmployeeID = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Register new employee");
            System.out.println("2. Calculate salary");
            System.out.println("3. Evaluate performance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    calculateEmployeeSalary();
                    break;
                case 3:
                    evaluateEmployeePerformance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("Select employee type:");
        System.out.println("1. Full-time");
        System.out.println("2. Part-time");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (type == 1) {
            System.out.print("Enter monthly salary: ");
            double monthlySalary = scanner.nextDouble();
            System.out.print("Enter performance bonus: ");
            double performanceBonus = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees.add(new FullTimeEmployee(name, nextEmployeeID++, monthlySalary, performanceBonus));
            System.out.println("Full-time employee registered successfully.");
        } else if (type == 2) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = scanner.nextDouble();
            System.out.print("Enter hours worked: ");
            int hoursWorked = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            employees.add(new PartTimeEmployee(name, nextEmployeeID++, hourlyRate, hoursWorked));
            System.out.println("Part-time employee registered successfully.");
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    private static void calculateEmployeeSalary() {
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) {
            if (employee.employeeID == employeeID) {
                employee.calculateSalary();
                System.out.println("Employee salary: " + employee.salary);
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    private static void evaluateEmployeePerformance() {
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) {
            if (employee.employeeID == employeeID) {
                employee.evaluatePerformance();
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}





// 1. Register New Employee
// 2. Calculate Salary
// 3. Evaluate Performance
// 4. Exit

// Enter your choice: 1
// Enter employee type (1 for Full-Time, 2 for Part-Time): 1
// Enter employee name: John Doe
// Enter employee ID: 101
// Enter monthly salary: 5000

// Employee registered successfully.

// Enter your choice: 2
// Enter employee ID to calculate salary: 101

// Monthly salary of employee ID 101 is $5000.00

// Enter your choice: 3
// Enter employee ID to evaluate performance: 101
// Performance evaluation not applicable for Full-Time employees.

// Enter your choice: 4
// Exiting...
