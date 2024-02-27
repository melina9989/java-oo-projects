package gr.aueb.cf.myPractice.bankApp.model;

/**
 * Represents a joint bank account with two holders.
 */
public class JointAccount {
    private OverdraftAccount account;
    private String holder1;
    private String holder2;

    public JointAccount() {
    }

    public JointAccount(OverdraftAccount account, String holder1, String holder2) {
        this.account = account;
        this.holder1 = holder1;
        this.holder2 = holder2;
    }

    public OverdraftAccount getAccount() {
        return account;
    }

    public void setAccount(OverdraftAccount account) {
        this.account = account;
    }

    public String getHolder1() {
        return holder1;
    }


    public String getHolder2() {
        return holder2;
    }


    /**
     * Returns the state of the joint account.
     * @return
     */
    @Override
    public String toString() {
        return "JointAccount{" +
                "account=" + account.accountToString() +
                ", holder1='" + holder1 + '\'' +
                ", holder2='" + holder2 + '\'' +
                '}';
    }
}

