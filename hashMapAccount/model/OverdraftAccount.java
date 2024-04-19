package gr.aueb.cf.myPractice.hashMapAccount.model;

public class OverdraftAccount extends Account {
    double overdraftLimit;
    public OverdraftAccount() {
    }

    public OverdraftAccount(long id, double overdraftLimit, User holder, String iban, double balance) {
        super(id, holder, iban, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public OverdraftAccount(Account account, double overdraftLimit) {
        super(account);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public String toString() {
        return "OverdraftAccount{" +
                " overdraftLimit= " + overdraftLimit +
                " id= " + getId() +
                " holder= " + getHolder() +
                " iban= " + getIban() +
                " balance= " + getBalance() +
                '}';
    }
}
