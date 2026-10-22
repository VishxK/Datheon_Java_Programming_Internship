package Bank_Account_and_ATM_Simulation_Engine;

public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
        if (initialBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least Rs." + MIN_BALANCE);
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Cannot withdraw Rs." + amount + ". Minimum balance of Rs." + MIN_BALANCE + " must be maintained.");
        }
        balance -= amount;
        transactionLog.add(new Transaction("WITHDRAWAL", amount, balance));
    }

}
