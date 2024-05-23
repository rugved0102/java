import java.util.*;

public class q13 {

    // Method to generate a random array of integers with a specified size and range of values
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return array;
    }

    // Method to rotate the elements of the array to the right by a specified number of positions
    public static void rotateRight(int[] array, int positions) {
        if (array == null || array.length == 0) return;
        int n = array.length;
        positions %= n;
        reverse(array, 0, n - 1);
        reverse(array, 0, positions - 1);
        reverse(array, positions, n - 1);
    }

    // Helper method to reverse the elements of the array within the specified range
    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Method to remove duplicate elements from the array while preserving the original order
    public static void removeDuplicates(int[] array) {
        if (array == null || array.length == 0) return;
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int index = 0;
        for (int num : set) {
            array[index++] = num;
        }
        while (index < array.length) {
            array[index++] = 0; // Fill remaining elements with 0 or any other default value
        }
    }

    // Method to rearrange the elements of the array such that even numbers appear before odd numbers
    public static void rearrangeEvenOdd(int[] array) {
        if (array == null || array.length == 0) return;
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 == 0) {
                left++;
            }
            while (left < right && array[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of array, min value, and max value
        System.out.print("Enter size of the array: ");
        int size = scanner.nextInt();
        System.out.print("Enter minimum value: ");
        int minValue = scanner.nextInt();
        System.out.print("Enter maximum value: ");
        int maxValue = scanner.nextInt();

        // Generate random array
        int[] array = generateRandomArray(size, minValue, maxValue);
        System.out.println("Original array: " + Arrays.toString(array));

        // Perform array manipulation operations
        System.out.print("Enter number of positions to rotate right: ");
        int positions = scanner.nextInt();
        rotateRight(array, positions);
        System.out.println("Array after rotating right by " + positions + " positions: " + Arrays.toString(array));

        removeDuplicates(array);
        System.out.println("Array after removing duplicates: " + Arrays.toString(array));

        rearrangeEvenOdd(array);
        System.out.println("Array after rearranging even and odd numbers: " + Arrays.toString(array));

        scanner.close();
    }
}
