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
                    handleLoginSession();
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

    private static void initializeSampleData() {
        Customer c1 = new Customer("C001", "Alice Perera", "1234");
        c1.addAccount(new SavingsAccount("SAV-1001", 500.00));
        c1.addAccount(new CheckingAccount("CHK-1001", 300.00, 150.00));
        bankCustomers.add(c1);

        Customer c2 = new Customer("C002", "Vishwa Omalka", "5678");
        c2.addAccount(new SavingsAccount("SAV-1002", 1250.00));
        bankCustomers.add(c2);
    }

    /// handleLoginSession() method manages the login process for a customer, including card number and PIN verification.
    private static void handleLoginSession() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine().trim();

        Customer customer = findCustomer(customerId);
        if (customer == null) {
            System.out.println("Error: Customer ID not found.");
            return;
        }

        try {
            System.out.print("Enter 4-digit PIN: ");
            String pin = scanner.nextLine().trim();
            if (!customer.verifyPin(pin)) {
                throw new InvalidPINException("Authentication failed: Incorrect PIN.");
            }

            System.out.println("\nLogin Successful! Welcome, " + customer.getName() + ".");
            runCustomerDashboard(customer); //run the customer dashboard after successful login

        } catch (InvalidPINException e) {
            System.out.println("Security Error: " + e.getMessage());
        }
    }

    /// findCustomer() method searches for a customer in the bankCustomers list based on the provided customer ID.
    private static Customer findCustomer(String customerId) {
        for (Customer c : bankCustomers) {
            if (c.getCustomerId().equalsIgnoreCase(customerId)) {
                return c;
            }
        }
        return null;
    }

    /// runCustomerDashboard() method provides a menu-driven interface for the logged-in customer to perform various banking operations.
    private static void runCustomerDashboard(Customer customer) {

    }

}
