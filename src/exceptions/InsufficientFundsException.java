package exceptions;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String text){
        super(text);
    }
}
