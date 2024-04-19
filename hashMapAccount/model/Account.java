package gr.aueb.cf.myPractice.hashMapAccount.model;

import java.util.Objects;

public class Account extends AbstractEntity {
    private User holder;
    private String iban;
    private double balance;

    public Account() {
    }

    public Account(long id, User holder, String iban, double balance) {
        this.setId(id);
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    public Account(Account account) {
        iban = account.getIban();
        balance = account.getBalance();
        holder = account.getHolder();
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + getId() +
                ", holder=" + holder +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(balance, account.balance) != 0) return false;
        if (!Objects.equals(holder, account.holder)) return false;
        return Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = holder != null ? holder.hashCode() : 0;
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
