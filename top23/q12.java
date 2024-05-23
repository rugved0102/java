import java.util.*;

public class q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part a: Remove duplicates from ArrayList
        System.out.println("Enter integer elements separated by spaces:");
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] elements = scanner.nextLine().split(" ");
        for (String element : elements) {
            arrayList.add(Integer.parseInt(element));
        }

        // Part a: Remove duplicates from ArrayList
        ArrayList<Integer> uniqueList = removeDuplicates(arrayList);
        System.out.println("Unique elements: " + uniqueList);

        // Part b: Various operations on ArrayList
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Check if an element exists in ArrayList");
            System.out.println("2. Add element at a particular index of ArrayList");
            System.out.println("3. Remove element at a particular index of ArrayList");
            System.out.println("4. Replace element at a particular index of ArrayList");
            System.out.println("5. Sort the ArrayList");
            System.out.println("6. Reverse the elements in the ArrayList");
            System.out.println("7. Compare two ArrayLists");
            System.out.println("8. Find first and last occurrence of repeated elements");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to check if it exists in ArrayList: ");
                    int elementToCheck = scanner.nextInt();
                    System.out.println("Element " + elementToCheck + " exists in ArrayList: " + arrayList.contains(elementToCheck));
                    break;
                case 2:
                    System.out.print("Enter an index to add an element to the ArrayList: ");
                    int indexToAdd = scanner.nextInt();
                    System.out.print("Enter the element to add: ");
                    int elementToAdd = scanner.nextInt();
                    arrayList.add(indexToAdd, elementToAdd);
                    System.out.println("ArrayList after adding element " + elementToAdd + " at index " + indexToAdd + ": " + arrayList);
                    break;
                case 3:
                    System.out.print("Enter an index to remove an element from the ArrayList: ");
                    int indexToRemove = scanner.nextInt();
                    arrayList.remove(indexToRemove);
                    System.out.println("ArrayList after removing element at index " + indexToRemove + ": " + arrayList);
                    break;
                case 4:
                    System.out.print("Enter an index to replace an element in the ArrayList: ");
                    int indexToReplace = scanner.nextInt();
                    System.out.print("Enter the new element: ");
                    int newElement = scanner.nextInt();
                    arrayList.set(indexToReplace, newElement);
                    System.out.println("ArrayList after replacing element at index " + indexToReplace + " with " + newElement + ": " + arrayList);
                    break;
                case 5:
                    Collections.sort(arrayList);
                    System.out.println("ArrayList after sorting: " + arrayList);
                    break;
                case 6:
                    Collections.reverse(arrayList);
                    System.out.println("ArrayList after reversing: " + arrayList);
                    break;
                case 7:
                    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
                    System.out.println("ArrayList and list2 are equal: " + arrayList.equals(list2));
                    break;
                case 8:
                    ArrayList<Integer> repeatedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 5, 4));
                    System.out.print("Enter the element to find its first and last occurrences in the ArrayList: ");
                    int elementToFind = scanner.nextInt();
                    int firstOccurrence = repeatedList.indexOf(elementToFind);
                    int lastOccurrence = repeatedList.lastIndexOf(elementToFind);
                    System.out.println("First occurrence of " + elementToFind + ": " + firstOccurrence);
                    System.out.println("Last occurrence of " + elementToFind + ": " + lastOccurrence);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Part a: Remove duplicates from ArrayList
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> arrayList) {
        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (Integer num : arrayList) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }

        return uniqueList;
    }
}
