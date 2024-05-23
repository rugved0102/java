import java.util.Scanner;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

public class q19 {

    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be null or empty");
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        // Check if email contains exactly one '@' and it is not the first or last character
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@') || atIndex == email.length() - 1) {
            throw new InvalidEmailException("Email must contain exactly one '@' and it cannot be the first or last character");
        }

        // Check if email contains '.' after '@' and at least one character between '@' and '.'
        if (dotIndex <= atIndex + 1 || dotIndex == email.length() - 1) {
            throw new InvalidEmailException("'.' must appear after '@' and there must be at least one character between '@' and '.'");
        }

        // Check if there are characters after the last '.'
        if (dotIndex == email.length() - 1) {
            throw new InvalidEmailException("Email must contain characters after '.'");
        }

        // Check for consecutive dots
        if (email.contains("..")) {
            throw new InvalidEmailException("Email cannot contain consecutive dots");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        try {
            validateEmail(email);
            System.out.println("The email address is valid.");
        } catch (InvalidEmailException e) {
            System.out.println("Invalid email address: " + e.getMessage());
        }

        scanner.close();
    }
}
