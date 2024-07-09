package exceptions;

public class DepositLimit extends Exception {
    public DepositLimit() {
        super("\nCard replenishment limit: 1000000");
    }
}
