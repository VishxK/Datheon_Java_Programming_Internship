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
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void initializeSampleData() {
        Customer c1 = new Customer("C001", "Kasun Perera", "1234");
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
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- ATM Account Menu ---");
            System.out.println("1. View Balances");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Print Audit Transaction Trail");
            System.out.println("5. Logout");

            int choice = getIntInput("Select option (1-5): ");
            switch (choice) {
                case 1:
                    viewBalances(customer);
                    break;
                case 2:
                    handleDeposit(customer);
                    break;
                case 3:
                    handleWithdrawal(customer);
                    break;
                case 4:
                    printAuditTrail(customer);
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Logged out securely.");
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }

    }



    private static void viewBalances(Customer customer) {
        System.out.println("\n--- Account Balances ---");
        for (Account acc : customer.getAccounts()) {
            System.out.printf("Account: %-10s | Balance: %.2f\n", acc.getAccountNumber(), acc.getBalance());
        }
    }

    private static void handleDeposit(Customer customer) {
        Account account = promptAndGetAccount(customer);
        if (account == null) return;

        double amount = getDoubleInput("Enter amount to deposit (Rs): ");
        try {
            account.deposit(amount);
            System.out.printf("Successfully deposited %.2f. New Balance: %.2f\n", amount, account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        }
    }

    private static void handleWithdrawal(Customer customer) {
        Account account = promptAndGetAccount(customer);
        if (account == null) return;

        double amount = getDoubleInput("Enter amount to withdraw (Rs): ");
        try {
            account.withdraw(amount);
            System.out.printf("Successfully withdrew %.2f. Remaining Balance: %.2f\n", amount, account.getBalance());
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Withdrawal Declined: " + e.getMessage());
        }
    }

    private static void printAuditTrail(Customer customer) {
        System.out.println("\n========================================================");
        System.out.println("            AUDIT TRAIL & TRANSACTION LOGS              ");
        System.out.println("========================================================");
        for (Account acc : customer.getAccounts()) {
            System.out.println("Account ID: " + acc.getAccountNumber());
            for (Transaction tx : acc.getTransactionLog()) {
                System.out.println("   " + tx);
            }
            System.out.println("--------------------------------------------------------");
        }
    }


    private static Account promptAndGetAccount(Customer customer) {
        List<Account> accounts = customer.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return null;
        }
        System.out.println("\nSelect Account:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), accounts.get(i).getAccountNumber());
        }
        int idx = getIntInput("Choice: ");
        if (idx < 1 || idx > accounts.size()) {
            System.out.println("Invalid selection.");
            return null;
        }
        return accounts.get(idx - 1);
    }


    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid currency amount.");
            }
        }
    }

}
