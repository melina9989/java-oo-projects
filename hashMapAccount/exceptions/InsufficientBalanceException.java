package gr.aueb.cf.myPractice.hashMapAccount.exceptions;



public class InsufficientBalanceException extends Exception{
    private final static long serialVersionUID = 123L;

    public InsufficientBalanceException(double amount, double balance) {
        super("Insufficient balance " + balance + " for amount " + amount);
    }
}
