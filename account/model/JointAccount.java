package gr.aueb.cf.myPractice.account.model;



public class JointAccount extends AbstractEntity{
    private Account account;
    private User secondHolder;

    public JointAccount() {

    }

    public JointAccount(Account account, User secondHolder) {
        this.account = account;
        this.secondHolder = secondHolder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getSecondHolder() {
        return secondHolder;
    }

    public void setSecondHolder(User secondHolder) {
        this.secondHolder = secondHolder;
    }
}
