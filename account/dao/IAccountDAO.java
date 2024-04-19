package gr.aueb.cf.myPractice.account.dao;

import gr.aueb.cf.myPractice.account.model.Account;
import gr.aueb.cf.myPractice.account.model.OverdraftAccount;

import java.util.List;

public interface IAccountDAO {

    /**
     * Inserts a new {@link Account} instance in the datasource.
     * @param account
     *          the model object that contains the account data.
     */
    void createAccount(Account account);


    /**
     *Returns a {@link Account} based on the input id.
     * @param id
     * @return
     *      the resulting {@link Account}
     */
    Account getAccountById(long id);


    /**
     *
     * @param oldAccount
     * @param newAccount
     * @return
     */
    Account updateAccount(Account oldAccount, Account newAccount);



    /**
     * Deletes an account from the database based on ints id.
     * @param id
     *      of the {@link Account} instance needed to be removed.
     */
    void deleteAccount(long id);

    /**
     * Credits an amount to the account with the specified id.
     * @param id
     *         the <code>id</code> to be searched for.
     * @param amount to be deposited.
     */
    void deposit(long id, double amount);

    /**
     * Returns the account's balance.
     * @param id
     *          the <code>id</code> to be searched for.
     * @return
     *      the balance.
     */
    double getAccountBalance(long id);

    /**
     * Withdraws a given amount with the specified ssn.
     * @param amount  to be withdrawn
     * @param id
     *         the <code>id</code> to be searched for.
     */
    void withdraw(double amount, Long id);

    /**
     * Returns a list of all accounts owned by a specific owner.
     * @param ownerId
     *              the <code>id</code> to be searched for.
     * @return
     * a list of all accounts owned by a specific owner.
     */
    List<Account> getAccountsByOwner(long ownerId);

    boolean isIdValid(Long id) ;

    Iterable<Object> getAccounts();

    void createOverdraftAccount(OverdraftAccount account);
}
