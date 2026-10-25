package Bank_Account_and_ATM_Simulation_Engine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDateTime timestamp;
    private final String type;
    private final double amount;
    private final double resultingBalance;

    public Transaction(String type, double amount, double resultingBalance) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.resultingBalance = resultingBalance;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] TYPE: %-12s | AMOUNT: %-9.2f | BALANCE: %.2f",
                timestamp.format(formatter), type, amount, resultingBalance);
    }
}
