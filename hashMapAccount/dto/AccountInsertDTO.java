package gr.aueb.cf.myPractice.hashMapAccount.dto;

public class AccountInsertDTO extends BaseDTO {
    private UserInsertDTO userInsertDTO;

    private String iban;
    private double balance;

    public AccountInsertDTO() {
    }

    public UserInsertDTO getUserInsertDTO() {
        return userInsertDTO;
    }

    public void setUserInsertDTO(UserInsertDTO userInsertDTO) {
        this.userInsertDTO = userInsertDTO;
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
