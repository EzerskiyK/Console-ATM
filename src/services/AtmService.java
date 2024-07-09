package services;

import entities.Atm;
import entities.BankCard;
import entities.SavedDataFromFile;
import exceptions.DepositLimit;
import exceptions.InsufficientFundsException;
import interfaces.FinancialOperations;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmService implements FinancialOperations {

    private final Scanner scanner;

    SavedDataFromFile savedDataFromFile = SavedDataFromFile.getDataFromFile();
    SavedDataFromFileService savedDataFromFileService = new SavedDataFromFileService(savedDataFromFile);
    {savedDataFromFileService.enrichFromFile();}

    Atm atm = savedDataFromFileService.initializationAtmFromFileData();

    BankCard bankCard = savedDataFromFileService.initializationBankCardFromFileData();
    BankCardService bankCardService = new BankCardService(bankCard);

    public AtmService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int checkBalance() {
        return this.atm.getAmountOfMoney();
    }

    @Override
    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > this.atm.getAmountOfMoney()) {
            throw new InsufficientFundsException("\nThere are not enough funds in the ATM\n");
        }else {
            this.atm.setAmountOfMoney(this.atm.getAmountOfMoney() - amount);

        }
    }

    @Override
    public void topUp(int amount) {
        this.atm.setAmountOfMoney(this.atm.getAmountOfMoney() + amount);
    }

    public void checkValidCardNumber() {
        while (true) {
            String cardNumber = this.scanner.nextLine();
            if (validateCardNumber(cardNumber)) {
                return;
            }
        }
    }

    private boolean validateCardNumber(String cardNumber) {
        if (cardNumber.equals(bankCard.getCardNumber())) {
            if (bankCard.isBlocked()) {
                System.out.println("Your account has been blocked.\n" +
                        "Your account will be unblocked: " + bankCard.getUnblockDate());
                System.exit(0);
            }
            return true;
        } else {
            System.out.println(cardNumber.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$") ?
                    "There's no card with that number. \nTry again" :
                    """

                            You have entered an invalid card number.
                            The card number should be of the form: XXXX-XXXX-XXXX-XXXX.
                            Try again.""");
            return false;
        }
    }

    public void checkPin() {
        for (int attempts = 3; attempts > 0; attempts--) {
            try {
                int pin = this.scanner.nextInt();
                if (validatePin(pin, attempts)) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a 4-digit pin.");
                System.out.println("Attempts left: " + (attempts - 1));
                scanner.next();
            }
        }
        blockAccount();
    }

    private boolean validatePin(int pin, int attempts) {
        if (pin == bankCard.getPin()) {
            return true;
        } else {
            System.out.println(pin > 999 && pin < 10000 ?
                    "The pin code is wrong.\n" +
                            "Attempts left: " + (attempts - 1) + ".\n" :
                    "You have entered an invalid pin code.\n" +
                            "The pin code must be 4 digits long.\n" +
                            "Attempts left: " + (attempts - 1) + ".\n");
            return false;
        }
    }

    private void blockAccount() {
        System.out.println("Your account is blocked for 24 hours");
        bankCard.setBlocked(true);
        bankCard.setUnblockDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
        savedDataFromFile.setCardUnblockDate(bankCard.getUnblockDate());
        savedDataFromFileService.saveToFile();
        savedDataFromFileService.saveToFile();
        System.exit(0);
    }


    public void checkBalanceOfCard() {
        System.out.println("\nYour card balance: " + this.bankCardService.checkBalance()+"\n");
    }

    public void withdrawFromCard() {
        System.out.println("\nEnter the amount you want to withdraw\n");
        int amount;
        while (true) {
            try {
                amount = scanner.nextInt();
                bankCardService.withdraw(amount);
                withdraw(amount);
                updateAndSaveBalancesForSavedDataFromFile();
                System.out.println("\nThe money was successfully withdrawn from the account!");
                return;
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
                System.out.println("\nTry again\n");
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next();
            }
        }
    }

    public void topUpTheCard() {
        System.out.println("\nEnter the amount you want to top up your card:\n");
        int amount;
        while (true) {
            try {
                amount = scanner.nextInt();
                bankCardService.topUp(amount);
                topUp(amount);
                updateAndSaveBalancesForSavedDataFromFile();
                System.out.println("\nThe account has been successfully replenished");
                return;
            } catch (DepositLimit e) {
                System.out.println(e.getMessage());
                System.out.println("\nTry again\n");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next();
            }
        }

    }

    private void updateAndSaveBalancesForSavedDataFromFile() {
        savedDataFromFile.setCardBalance(bankCard.getBalance());
        savedDataFromFile.setAtmAmountOfMoney(atm.getAmountOfMoney());
        savedDataFromFileService.saveToFile();

    }
}
