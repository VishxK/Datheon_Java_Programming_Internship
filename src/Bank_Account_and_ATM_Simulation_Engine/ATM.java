package Bank_Account_and_ATM_Simulation_Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private static List<Customer> bankCustomers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            System.out.println("\n========================================");
            System.out.println("      WELCOME TO LK BANK ATM       ");
            System.out.println("========================================");
            System.out.println("1. Insert Card / Login");
            System.out.println("2. Exit ATM");
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    /// handleLoginSession() method manages the login process for a customer, including card number and PIN verification.
                    //handleLoginSession();
                    break;
                case 2:
                    running = false;
                    System.out.println("Thank you for using LK Bank ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }
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
