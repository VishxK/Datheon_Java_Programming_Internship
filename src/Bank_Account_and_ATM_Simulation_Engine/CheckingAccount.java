package Bank_Account_and_ATM_Simulation_Engine;

public class CheckingAccount extends Account {
    private final double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if ((balance - amount) < (-overdraftLimit)) {
            throw new InsufficientFundsException("Exceeded overdraft limit of Rs." + overdraftLimit);
        }
        balance -= amount;
        transactionLog.add(new Transaction("WITHDRAW", amount, balance));
    }
}