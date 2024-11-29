import java.util.Scanner;

public class Grading_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's marks (0-100): ");
        int marks = scanner.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid input! Marks should be between 0 and 100.");
        } else {
            String grade;
            if (marks >= 90) {
                grade = "A+";
            } else if (marks >= 80) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "B+";
            } else if (marks >= 60) {
                grade = "B";
            } else if (marks >= 50) {
                grade = "C";
            } else if (marks >= 40) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println("The student's grade is: " + grade);
        }

        scanner.close();
    }
}
