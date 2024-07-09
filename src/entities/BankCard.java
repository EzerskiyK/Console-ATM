package entities;

import java.util.Date;

public class BankCard {

    private String cardNumber;
    private int pin;
    private int balance;
    private boolean blocked;
    private Date unblockDate;

    public BankCard(String cardNumber, int pin, int balance, Date unblockDate) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.unblockDate = unblockDate;
        this.blocked = unblockDate.after(new Date());
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Date getUnblockDate() {
        return unblockDate;
    }

    public void setUnblockDate(Date unblockDate) {
        this.unblockDate = unblockDate;
    }
}
