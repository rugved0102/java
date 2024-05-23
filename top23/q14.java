import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q14 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }
        
        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            resultArray[index++] = num;
        }
        
        return resultArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of nums1 (space-separated):");
        String[] nums1Str = scanner.nextLine().split(" ");
        int[] nums1 = new int[nums1Str.length];
        for (int i = 0; i < nums1Str.length; i++) {
            nums1[i] = Integer.parseInt(nums1Str[i]);
        }

        System.out.println("Enter the elements of nums2 (space-separated):");
        String[] nums2Str = scanner.nextLine().split(" ");
        int[] nums2 = new int[nums2Str.length];
        for (int i = 0; i < nums2Str.length; i++) {
            nums2[i] = Integer.parseInt(nums2Str[i]);
        }

        int[] intersectionResult = intersection(nums1, nums2);

        System.out.print("Intersection: ");
        for (int num : intersectionResult) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}

// 1 2 3
//  5 6 77