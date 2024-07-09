package services;

import entities.BankCard;
import exceptions.InsufficientFundsException;
import exceptions.DepositLimit;
import interfaces.FinancialOperations;

public class BankCardService implements FinancialOperations  {

    private final BankCard bankCard;
    public BankCardService(BankCard bankCard) {
        this.bankCard = bankCard;
    }


    @Override
    public int checkBalance() {
        return this.bankCard.getBalance();
    }

    @Override
    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > bankCard.getBalance()) {
            throw new InsufficientFundsException("\ninsufficient funds\n");
        }else{
            bankCard.setBalance(bankCard.getBalance() - amount);
        }

    }

    @Override
    public void topUp(int amount) throws DepositLimit {
        if (amount > 1000000) {
            throw new DepositLimit();
        }
        bankCard.setBalance(bankCard.getBalance() + amount);
    }
}
