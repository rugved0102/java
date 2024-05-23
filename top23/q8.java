import java.util.Arrays;
import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A. Initialize an array with given elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // B. Find the sum of all elements in the array
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum of all elements in the array: " + sum);

        // C. Find the maximum element in the array
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Maximum element in the array: " + max);

        // D. Find the minimum element in the array
        int min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Minimum element in the array: " + min);

        // E. Sort the elements of the array in ascending order
        Arrays.sort(array);
        System.out.println("Array after sorting in ascending order: " + Arrays.toString(array));

        // F. Reverse the elements of the array
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
        System.out.println("Array after reversing: " + Arrays.toString(array));

        scanner.close();
    }
}

// 5
// 4 7 2 9 5
