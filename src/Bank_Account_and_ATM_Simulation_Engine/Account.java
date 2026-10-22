package Bank_Account_and_ATM_Simulation_Engine;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactionLog;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionLog = new ArrayList<>();
        transactionLog.add(new Transaction("OPENING", initialBalance, balance));
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionLog() {
        return transactionLog;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount shouldn't be zero.");
        }
        balance += amount;
        transactionLog.add(new Transaction("DEPOSIT", amount, balance));
    }

    public abstract void withdraw(double amount) throws InsufficientFundsException;
}
