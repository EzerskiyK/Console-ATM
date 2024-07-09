package interfaces;

import exceptions.DepositLimit;
import exceptions.InsufficientFundsException;

public interface FinancialOperations {
    int checkBalance() ;
    void withdraw(int amount) throws InsufficientFundsException;
    void topUp(int amount) throws DepositLimit;
}
