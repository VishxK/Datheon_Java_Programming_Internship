package Bank_Account_and_ATM_Simulation_Engine;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
