package entities;

import java.util.*;

public class SavedDataFromFile {

    private String cardNumber;
    private int cardPin;
    private int cardBalance;
    private Date cardUnblockDate;
    private int atmAmountOfMoney;
    private int atmWithdrawalLimit;

    private SavedDataFromFile(){}

    public static SavedDataFromFile getDataFromFile(){
        return new SavedDataFromFile();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardPin() {
        return cardPin;
    }

    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Date getCardUnblockDate() {
        return cardUnblockDate;
    }

    public void setCardUnblockDate(Date cardUnblockDate) {
        this.cardUnblockDate = cardUnblockDate;
    }

    public int getAtmAmountOfMoney() {
        return atmAmountOfMoney;
    }

    public void setAtmAmountOfMoney(int atmAmountOfMoney) {
        this.atmAmountOfMoney = atmAmountOfMoney;
    }

    public int getAtmWithdrawalLimit() {
        return atmWithdrawalLimit;
    }

    public void setAtmWithdrawalLimit(int atmWithdrawalLimit) {
        this.atmWithdrawalLimit = atmWithdrawalLimit;
    }

    @Override
    public String toString() {
        return "SavedDataFromFile{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardPin=" + cardPin +
                ", cardBalance=" + cardBalance +
                ", cardUnblockDate=" + cardUnblockDate +
                ", atmAmountOfMoney=" + atmAmountOfMoney +
                ", atmWithdrawalLimit=" + atmWithdrawalLimit +
                '}';
    }
}
