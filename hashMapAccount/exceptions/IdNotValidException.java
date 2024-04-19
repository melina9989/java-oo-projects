package gr.aueb.cf.myPractice.hashMapAccount.exceptions;

public class IdNotValidException extends Exception{
    private final static long serialVersionUID = 13221L;

    public IdNotValidException(Long id) {
        super("Id " + id + " not valid.");
    }
}
