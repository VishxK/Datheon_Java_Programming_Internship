import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    private static ArrayList<Student> studentCohort = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Main loop to keep the program running until the user decides to exit
        boolean isValid = true;
        while (isValid) {
            printMenu();
            int choice = getIntInput("Choose an Option 1-5: ");

            switch (choice) {
                case 1:
                    addStudent();

                    break;
                case 2:
                    recordStudentMarks();

                    break;
                case 3:
                    computeClassmetrics();

                    break;
                case 4:
                    generateReportCards();

                    break;
                case 5:
                    System.out.println("Exiting Student Grade Management System. Goodbye!");
                    isValid = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }
        }

    }


    /// printMenu() method displays the main menu options to the user.

    private static void printMenu() {
        System.out.println("\n | Student Grade Management System | ");
        System.out.println("1. Add Student");
        System.out.println("2. Record Student Marks");
        System.out.println("3. Compute Class Metrics");
        System.out.println("4. Generate Report Cards");
        System.out.println("5. Exit");
    }

    /// getIntInput() method prompts the user for an integer input and handles invalid inputs gracefully.

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

}
