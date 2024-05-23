import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double grade;

    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManager implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void replaceGrade(int rollNumber, double newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setGrade(newGrade);
                break;
            }
        }
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}

public class q1 {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display all students");
            System.out.println("4. Replace grade of a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    studentManager.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    studentManager.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.println("List of students:");
                    studentManager.displayAllStudents();
                    break;
                case 4:
                    System.out.print("Enter roll number of student to replace grade: ");
                    int rollToReplace = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    studentManager.replaceGrade(rollToReplace, newGrade);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
// 1
// John
// 101
// 89.5
// 1
// Jane
// 102
// 91.2
// 1
// Alex
// 103
// 85.0
// 3
// 2
// 102
// 3
// 4
// 101
// 95.0
// 3
// 5
