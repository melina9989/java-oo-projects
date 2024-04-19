package gr.aueb.cf.myPractice.hashMapAccount.dto;

public class AccountUpdateDTO extends BaseDTO {
    private UserUpdateDTO userUpdateDTO;
    private String iban;
    private double balance;

    public AccountUpdateDTO() {
    }

    public UserUpdateDTO getUserUpdateDTO() {
        return userUpdateDTO;
    }

    public void setUserUpdateDTO(UserUpdateDTO userUpdateDTO) {
        this.userUpdateDTO = userUpdateDTO;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
