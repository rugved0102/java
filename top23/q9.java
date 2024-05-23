import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A. Concatenate two strings
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        String concatenatedString = str1 + str2;
        System.out.println("Concatenated string: " + concatenatedString);

        // B. Find the length of a string
        System.out.println("Length of the first string: " + str1.length());

        // C. Convert a string to uppercase
        String upperCaseString = str1.toUpperCase();
        System.out.println("Uppercase string: " + upperCaseString);

        // D. Convert a string to lowercase
        String lowerCaseString = str1.toLowerCase();
        System.out.println("Lowercase string: " + lowerCaseString);

        // E. Check if a string contains a specific substring
        System.out.print("Enter a substring to search in the first string: ");
        String substring = scanner.nextLine();
        boolean containsSubstring = str1.contains(substring);
        System.out.println("First string contains the substring? " + containsSubstring);

        // F. Replace a substring with another substring in a string
        System.out.print("Enter the substring to replace: ");
        String toReplace = scanner.nextLine();
        System.out.print("Enter the new substring: ");
        String replacement = scanner.nextLine();
        String replacedString = str1.replace(toReplace, replacement);
        System.out.println("String after replacement: " + replacedString);

        scanner.close();
    }
}
// hello
// world
// lo
// world
