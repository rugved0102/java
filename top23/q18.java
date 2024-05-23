import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q18 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }
            charIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String inputString = scanner.nextLine();

        int result = lengthOfLongestSubstring(inputString);
        System.out.println("Length of the longest substring without repeating characters: " + result);

        scanner.close();
    }
}
