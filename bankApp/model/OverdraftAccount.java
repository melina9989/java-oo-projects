package gr.aueb.cf.myPractice.bankApp.model;

/**
 * Represents an account from which someone can
 * withdraw more than the balance of the account.
 */
public class OverdraftAccount {
    private int id;
    private String iban;
    private String ssn;
    private double balance;

    private final double overdraftLimit = 1000.0;

    public OverdraftAccount() {
    }

    public OverdraftAccount(int id, String iban, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.ssn = ssn;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
     *Public API - Business Services
     */

    /**
     * Withdraws a certain amount of money based on a
     * valid ssn.Ιf the monetary balance is not sufficient,
     * it is possible to withdraw by credit.
     * @param amount
     *      the ammount of money to be withdrawn.
     * @param ssn
     *      the given ssn.
     * @throws Exception
     *      if the ssn is not valid or if the balance
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)){
                throw new Exception("Bad ssn");
            }
            if (amount > balance) {
                System.out.println("Υour account will be credited with the amount " + calculateRemainingBalance(amount, balance));
            }
            if (amount > balance + overdraftLimit) {
                throw new Exception("Withdrawal amount exceeds balance and overdraft limit");
            }

            balance -= amount;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private boolean isSsnValid(String ssn) {
        return this.ssn.equals(ssn);
    }

    private double calculateRemainingBalance(double amount, double balance) {
        return (balance - amount);
    }

    /**
     * Deposits a certain amount of money in
     * the Account
     *
     * @param amount
     *      the amount to be deposited.
     * @throws Exception
     *      if the amount of money is negative.
     */
    public void deposit(double amount) throws Exception {
        try {
            if (amount < 0) {
                throw new Exception("Negative amount error");
            }
            balance += amount;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *Deposits a certain amount of money in
     * the Account to repay the credit.
     * @param amount to be repaid.
     * @throws Exception
     *      if the amount of money is negative.
     */
    public void debtRepayment (double amount) throws Exception {
        deposit(amount);
        System.out.println("The new balance after repayment is " + balance);
    }

    /**
     * Returns account's balance.
     * @return
     */
    public double getAccountBalance() {
        return getBalance();
    }

    /**
     *
     * @returns the state of the account
     */
    public String accountToString() {
        return "(" + id + "\t" + iban + "\t" + "\t" + ssn + "\t" + balance +
                "\t" + overdraftLimit
                + ")";
    }


}
