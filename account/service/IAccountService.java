package gr.aueb.cf.myPractice.account.service;

import gr.aueb.cf.myPractice.account.exceptions.InsufficientBalanceException;
import gr.aueb.cf.myPractice.account.exceptions.NegativeAmountException;
import gr.aueb.cf.myPractice.account.dto.AccountInsertDTO;
import gr.aueb.cf.myPractice.account.dto.AccountUpdateDTO;
import gr.aueb.cf.myPractice.account.exceptions.IdNotValidException;
import gr.aueb.cf.myPractice.account.model.Account;

import java.util.List;

public interface IAccountService {

    Account createAccount(AccountInsertDTO accountInsertDTO);

    void updateAccount(AccountUpdateDTO oldDTO, AccountUpdateDTO newDTO);

    Account getAccount(Long id)
            throws IdNotValidException;

    void deleteAccount(Long id)
            throws IdNotValidException;

    void deposit(long id, double amount)
            throws IdNotValidException, NegativeAmountException;

    double getAccountBalance(long id)
            throws IdNotValidException;

    void withdraw(double amount, Long id)
            throws InsufficientBalanceException, IdNotValidException;

    List<Account> getAccountsByOwner(long ownerId)
            throws IdNotValidException;
}
