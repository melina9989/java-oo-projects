package gr.aueb.cf.myPractice.account.dao;

import gr.aueb.cf.myPractice.account.model.Account;
import gr.aueb.cf.myPractice.account.model.OverdraftAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl implements IAccountDAO{
    private static final List<Account> accounts = new ArrayList<>();
    @Override
    public void createAccount(Account account) {
        accounts.add(account);
    }

    public void createOverdraftAccount(OverdraftAccount account) {
        accounts.add(account);
    }

    @Override
    public Account getAccountById(long searchedId) {
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getId().equals(searchedId))
                .findFirst();
        return account.orElse(null);
    }

    @Override
    public Account updateAccount(Account oldAccount, Account newAccount) {
        accounts.set(accounts.indexOf(oldAccount), newAccount);
        return newAccount;
    }


    @Override
    public void deleteAccount(long searchedId) {
        accounts.removeIf((account -> account.getId().equals(searchedId)));
    }

    @Override
    public void deposit(long id, double amount) {
       double newBalance = getAccountBalance(id) + amount;
       getAccountById(id).setBalance(newBalance);
    }

    @Override
    public double getAccountBalance(long searchedId) {
        return getAccountById(searchedId).getBalance();
    }

    @Override
    public void withdraw(double amount, Long id) {
        Account account = getAccountById(id);
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
    }

    @Override
    public List<Account> getAccountsByOwner(long ownerId) {
        List<Account> ownerAccounts = new ArrayList<>();

        for (Account account : accounts) {
            if (account.getHolder().getId().equals(ownerId)) {
                ownerAccounts.add(account);
            }
        }
        return ownerAccounts;

    }

    @Override
    public Iterable<Object> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    @Override
    public boolean isIdValid(Long id) {
        return accounts.stream()
                .anyMatch(c -> c.getId().equals(id));
    }
}
