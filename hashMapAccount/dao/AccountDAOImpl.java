package gr.aueb.cf.myPractice.hashMapAccount.dao;

import gr.aueb.cf.myPractice.hashMapAccount.model.Account;
import gr.aueb.cf.myPractice.hashMapAccount.model.JointAccount;
import gr.aueb.cf.myPractice.hashMapAccount.model.OverdraftAccount;

import java.util.*;

public class AccountDAOImpl implements IAccountDAO {
    private static final Map<Long, Account> accounts = new HashMap<>();
    private Iterator<Map.Entry<Long, Account>> iterator = accounts.entrySet().iterator();

    @Override
    public void createAccount(Long id,Account account) {
        accounts.put(id, account);
    }

    public void createOverdraftAccount(Long id ,OverdraftAccount account) {
        accounts.put(id, account);
    }

    @Override
    public void createJointAccount(Long id , JointAccount account) {
        accounts.put(id, account);
    }


    @Override
    public Account getAccountById(long searchedId) {
        Optional<Account> account = accounts.values().stream()
                .filter(a -> a.getId().equals(searchedId))
                .findFirst();
        return account.orElse(null);
    }

    @Override
    public boolean updateAccount(Account oldAccount, Account newAccount) {
        return accounts.replace(oldAccount.getId(),oldAccount, newAccount);
    }


    @Override
    public void deleteAccount(long searchedId) {
        while (iterator.hasNext()) {
            Map.Entry<Long, Account> entry = iterator.next();
            if (entry.getKey().equals(getAccountById(searchedId))) {
                iterator.remove();
            }
        }
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

        for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getHolder().getId().equals(ownerId)) {
                ownerAccounts.add(entry.getValue());
            }
        }
        return ownerAccounts;

    }

    @Override
    public Iterable<Object> getAccounts() {
        return Collections.unmodifiableList(Arrays.asList(accounts.entrySet().toArray()));
    }

    @Override
    public boolean isIdValid(Long id) {
        return accounts.entrySet().stream()
                .anyMatch(c -> c.getKey().equals(id));
    }
}
