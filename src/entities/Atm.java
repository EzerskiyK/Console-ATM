package entities;

public class Atm {

    private int amountOfMoney;
    private int withdrawalLimit;

    public Atm(int amountOfMoney, int withdrawalLimit) {
        this.amountOfMoney = amountOfMoney;
        this.withdrawalLimit = withdrawalLimit;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(int withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }
}
