import java.util.Scanner;

public class q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Check if the given number is Armstrong
        System.out.print("a. Enter a number to check if it's Armstrong: ");
        int number = scanner.nextInt();
        boolean isArmstrong = isArmstrong(number);
        System.out.println(number + " is " + (isArmstrong ? "Armstrong" : "not Armstrong"));

        // b. Check if two strings are anagrams
        System.out.print("b. Enter the first string: ");
        String str1 = scanner.next();
        System.out.print("   Enter the second string: ");
        String str2 = scanner.next();
        boolean areAnagrams = areAnagrams(str1, str2);
        System.out.println("   Strings \"" + str1 + "\" and \"" + str2 + "\" are " + (areAnagrams ? "anagrams" : "not anagrams"));

        // c. Compare two dates of birth (DOB) strings
        System.out.print("c. Enter first date of birth (in format DD/MM/YYYY): ");
        String dob1 = scanner.next();
        System.out.print("   Enter second date of birth (in format DD/MM/YYYY): ");
        String dob2 = scanner.next();
        String comparisonResult = compareDOB(dob1, dob2);
        System.out.println("   " + comparisonResult);

        // d. Check if the given number is prime
        System.out.print("d. Enter a number to check if it's prime: ");
        int num = scanner.nextInt();
        boolean isPrime = isPrime(num);
        System.out.println(num + " is " + (isPrime ? "prime" : "not prime"));

        scanner.close();
    }

    // Function to check if a number is Armstrong
    private static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 3); // Assuming it's a 3-digit Armstrong number
            number /= 10;
        }
        return sum == originalNumber;
    }

    // Function to check if two strings are anagrams
    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);
        return java.util.Arrays.equals(charArray1, charArray2);
    }

    // Function to compare two dates of birth (DOB) strings
    private static String compareDOB(String dob1, String dob2) {
        String[] parts1 = dob1.split("/");
        String[] parts2 = dob2.split("/");
    
        int day1 = Integer.parseInt(parts1[0]);
        int month1 = Integer.parseInt(parts1[1]);
        int year1 = Integer.parseInt(parts1[2]);
    
        int day2 = Integer.parseInt(parts2[0]);
        int month2 = Integer.parseInt(parts2[1]);
        int year2 = Integer.parseInt(parts2[2]);
    
        if (year1 > year2) {
            return "DOB1 is Younger";
        } else if (year1 < year2) {
            return "DOB1 is Elder";
        } else {
            if (month1 > month2) {
                return "DOB1 is Younger";
            } else if (month1 < month2) {
                return "DOB1 is Elder";
            } else {
                if (day1 > day2) {
                    return "DOB1 is Younger";
                } else if (day1 < day2) {
                    return "DOB1 is Elder";
                } else {
                    return "DOB1 is Same age";
                }
            }
        }
    }
    

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
