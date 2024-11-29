import java.util.Arrays;
import java.util.Scanner;

public class SecondSmallestAndLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Array must have at least two elements.");
        } else {
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Sort the array
            Arrays.sort(arr);

            // Find second smallest and second largest
            int secondSmallest = arr[0], secondLargest = arr[n - 1];
            boolean foundSecondSmallest = false, foundSecondLargest = false;

            // Find the second distinct smallest
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[0]) {
                    secondSmallest = arr[i];
                    foundSecondSmallest = true;
                    break;
                }
            }

            // Find the second distinct largest
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] < arr[n - 1]) {
                    secondLargest = arr[i];
                    foundSecondLargest = true;
                    break;
                }
            }

            // Display results
            if (foundSecondSmallest) {
                System.out.println("Second Smallest: " + secondSmallest);
            } else {
                System.out.println("No second smallest value (all elements are equal).");
            }

            if (foundSecondLargest) {
                System.out.println("Second Largest: " + secondLargest);
            } else {
                System.out.println("No second largest value (all elements are equal).");
            }
        }

        scanner.close();
    }
}
