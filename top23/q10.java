import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class WordCounter {
    public int countUniqueWords(String text) {
        // Split the text into words using whitespace as delimiter
        String[] words = text.split("\\s+");
        
        // Create a HashSet to store unique words
        Set<String> uniqueWords = new HashSet<>();

        // Add each word to the HashSet
        for (String word : words) {
            uniqueWords.add(word);
        }

        // Return the size of the HashSet, which represents the count of unique words
        return uniqueWords.size();
    }
}

public class q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordCounter wordCounter = new WordCounter();

        // Prompt the user to enter a text string
        System.out.print("Enter a text string: ");
        String text = scanner.nextLine();

        // Count the number of unique words in the input text
        int uniqueWordCount = wordCounter.countUniqueWords(text);

        // Display the number of unique words
        System.out.println("Number of unique words: " + uniqueWordCount);

        scanner.close();
    }
}
//This is a simple Java program. Java is powerful and simple.