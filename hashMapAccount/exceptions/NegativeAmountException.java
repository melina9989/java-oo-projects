package gr.aueb.cf.myPractice.hashMapAccount.exceptions;

public class NegativeAmountException extends Exception{
    private final static long serialVersionUID = 1312L;

    public NegativeAmountException(double amount) {
        super("The amount" + amount + "is not sufficient.");
    }
}
