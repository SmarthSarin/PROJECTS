// import java.util.Scanner;

// public class MultiArrayTable {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Take input for rows and columns
//         System.out.print("Enter the number of rows: ");
//         int rows = scanner.nextInt();
//         System.out.print("Enter the number of columns: ");
//         int cols = scanner.nextInt();

//         // Initialize the 2D array
//         int[][] array = new int[rows][cols];
        
//         // Fill the array with sequential numbers
//         int count = 1;
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 array[i][j] = count++;
//             }
//         }

//         // Print the array in table form
//         System.out.println("\nGenerated Array:");
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 System.out.printf("%3d ", array[i][j]);
//             }
//             System.out.println();
//         }
        
//         scanner.close();
//     }
// }
import java.util.*;
public class MultiArrayTable {
    public static void main(String[] args) {
        int[] writeanyname = new int [3];
        writeanyname[0]=97;
        writeanyname[1]=65;
        writeanyname[2]=98;
        System.out.println(writeanyname[0]);
    };
}