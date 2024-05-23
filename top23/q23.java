import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String grade;
    private String contactInfo;

    public Student(int id, String name, int age, String gender, String grade, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                ", Grade='" + grade + '\'' +
                ", Contact Info='" + contactInfo + '\'' +
                '}';
    }
}

public class q23 {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static void main(String[] args) {
        if (!login()) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        while (true) {
            displayMenu();
            int choice = getValidIntInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private static void displayMenu() {
        System.out.println("\nStudent Database Management System");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student by ID");
        System.out.println("3. Update student information");
        System.out.println("4. Display all students");
        System.out.println("5. Search for a student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        int id = getValidIntInput("Enter student ID: ");
        if (findStudentById(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int age = getValidIntInput("Enter student age: ");
        System.out.print("Enter student gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter student contact info: ");
        String contactInfo = scanner.nextLine();

        Student student = new Student(id, name, age, gender, grade, contactInfo);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        int id = getValidIntInput("Enter student ID to remove: ");
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        int id = getValidIntInput("Enter student ID to update: ");
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter new age (leave blank to keep current): ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) {
            try {
                student.setAge(Integer.parseInt(ageStr));
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Keeping current age.");
            }
        }

        System.out.print("Enter new gender (leave blank to keep current): ");
        String gender = scanner.nextLine();
        if (!gender.isEmpty()) {
            student.setGender(gender);
        }

        System.out.print("Enter new grade (leave blank to keep current): ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) {
            student.setGrade(grade);
        }

        System.out.print("Enter new contact info (leave blank to keep current): ");
        String contactInfo = scanner.nextLine();
        if (!contactInfo.isEmpty()) {
            student.setContactInfo(contactInfo);
        }

        System.out.println("Student information updated successfully.");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.println("Search by: 1. ID 2. Name 3. Grade 4. Other");
        int choice = getValidIntInput();

        switch (choice) {
            case 1:
                int id = getValidIntInput("Enter student ID: ");
                Student studentById = findStudentById(id);
                if (studentById != null) {
                    System.out.println(studentById);
                } else {
                    System.out.println("Student not found.");
                }
                break;
            case 2:
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                searchStudentByName(name);
                break;
            case 3:
                System.out.print("Enter student grade: ");
                String grade = scanner.nextLine();
                searchStudentByGrade(grade);
                break;
            case 4:
                System.out.print("Enter search criteria: ");
                String criteria = scanner.nextLine();
                searchStudentByOtherCriteria(criteria);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the name " + name);
        }
    }

    private static void searchStudentByGrade(String grade) {
        boolean found = false;
        for (Student student : students) {
            if (student.getGrade().equalsIgnoreCase(grade)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the grade " + grade);
        }
    }

    private static void searchStudentByOtherCriteria(String criteria) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(criteria) || 
                student.getGender().equalsIgnoreCase(criteria) ||
                student.getContactInfo().contains(criteria)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found matching the criteria " + criteria);
        }
    }

    private static int getValidIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static int getValidIntInput(String prompt) {
        System.out.print(prompt);
        return getValidIntInput();
    }
}
