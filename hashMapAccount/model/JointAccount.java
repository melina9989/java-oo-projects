package gr.aueb.cf.myPractice.hashMapAccount.model;



public class JointAccount extends Account {
    private User secondHolder;

    public JointAccount() {

    }

    public JointAccount(long id, User holder,User secondHolder  ,String iban, double balance) {
        super(id, holder, iban, balance);
        this.secondHolder = secondHolder;
    }



    public User getSecondHolder() {
        return secondHolder;
    }

    public void setSecondHolder(User secondHolder) {
        this.secondHolder = secondHolder;
    }

    @Override
    public String toString() {
        return "JointAccount{" +
                "id=" + getId() +
                ", holder=" + getHolder() +
                ", secondHolder=" + secondHolder +
                ", iban='" + getIban() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
