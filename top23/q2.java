import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int employeeID;
    private double hourlyRate;

    public Employee(String name, int employeeID, double hourlyRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculateMonthlySalary() {
        return 0; // Overridden by subclasses
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Employee ID: " + employeeID + ", Hourly Rate: $" + hourlyRate;
    }
}

class FullTimeEmployee extends Employee {
    private double salary;
    private String benefits;

    public FullTimeEmployee(String name, int employeeID, double hourlyRate, double salary, String benefits) {
        super(name, employeeID, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    @Override
    public double calculateMonthlySalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: $" + salary + ", Benefits: " + benefits;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double overtimeRate;

    public PartTimeEmployee(String name, int employeeID, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeID, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateMonthlySalary() {
        double regularPay = getHourlyRate() * hoursWorked;
        double overtimePay = hoursWorked > 160 ? (hoursWorked - 160) * overtimeRate : 0;
        return regularPay + overtimePay;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hours Worked: " + hoursWorked + ", Overtime Rate: $" + overtimeRate;
    }
}

public class q2 {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void calculateSalaries() {
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeID() + ", Monthly Salary: $" + employee.calculateMonthlySalary());
        }
    }

    public static void main(String[] args) {
        q2 manager = new q2();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a full-time employee");
            System.out.println("2. Add a part-time employee");
            System.out.println("3. Display all employees");
            System.out.println("4. Calculate and display monthly salaries");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String ftName = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int ftEmployeeID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double ftHourlyRate = scanner.nextDouble();
                    System.out.print("Enter salary: ");
                    double ftSalary = scanner.nextDouble();
                    System.out.print("Enter benefits: ");
                    String ftBenefits = scanner.next();
                    manager.addEmployee(new FullTimeEmployee(ftName, ftEmployeeID, ftHourlyRate, ftSalary, ftBenefits));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String ptName = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int ptEmployeeID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double ptHourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    int ptHoursWorked = scanner.nextInt();
                    System.out.print("Enter overtime rate: ");
                    double ptOvertimeRate = scanner.nextDouble();
                    manager.addEmployee(new PartTimeEmployee(ptName, ptEmployeeID, ptHourlyRate, ptHoursWorked, ptOvertimeRate));
                    break;
                case 3:
                    manager.displayAllEmployees();
                    break;
                case 4:
                    manager.calculateSalaries();
                    break;
                case 5:
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
