package gr.aueb.cf.myPractice.account.service;

import gr.aueb.cf.ch18.dto.MobileContactUpdateDTO;
import gr.aueb.cf.myPractice.account.dao.IAccountDAO;
import gr.aueb.cf.myPractice.account.dto.*;
import gr.aueb.cf.myPractice.account.exceptions.IdNotValidException;
import gr.aueb.cf.myPractice.account.exceptions.InsufficientBalanceException;
import gr.aueb.cf.myPractice.account.exceptions.NegativeAmountException;
import gr.aueb.cf.myPractice.account.model.Account;
import gr.aueb.cf.myPractice.account.model.OverdraftAccount;
import gr.aueb.cf.myPractice.account.model.User;

import java.util.List;

public class AccountServiceImpl implements IAccountService{
    private final IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }
    @Override
    public Account createAccount(AccountInsertDTO accountInsertDTO) {
        Account account;
        account = mapFromInsertDTO(accountInsertDTO);
        dao.createAccount(account);
        System.out.println("Account created.");
        return account;
    }

    public OverdraftAccount createOverdraftAccount(OverdraftAccountInsertDTO overdraftAccountInsertDTO) {
        OverdraftAccount account;
        account = mapFromInsertDTO(overdraftAccountInsertDTO);
        dao.createOverdraftAccount(account);
        System.out.println("Overdraft Account created.");
        return account;
    }

    @Override
    public void updateAccount(AccountUpdateDTO oldDTO, AccountUpdateDTO newDTO) {
        Account oldAccount;
        oldAccount = mapFromUpdateDTO(oldDTO);
        Account updatedAccount;
        updatedAccount = mapFromUpdateDTO(newDTO);
        dao.updateAccount(oldAccount, updatedAccount);
        System.out.println("Account updated.");
    }

    @Override
    public Account getAccount(Long id)
            throws IdNotValidException {
        Account account;
        try{
            account = dao.getAccountById(id);
            if (account == null) {
                throw new IdNotValidException(id);
            }
            return account;
        }catch (IdNotValidException e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void deleteAccount(Long id)
            throws IdNotValidException {
        try {
            if (!dao.isIdValid(id)) {
                throw new IdNotValidException(id);
            }
            dao.deleteAccount(id);
        }catch (IdNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deposit(long id, double amount)
            throws IdNotValidException, NegativeAmountException {
        try {

            if (!dao.isIdValid(id)) {
                throw new IdNotValidException(id);
            }
            if (amount <= 0) {
                throw new NegativeAmountException(amount);
            }
            dao.deposit(id, amount);
            System.out.println("The amount " + amount + " has deposited successfully");
        }catch (IdNotValidException | NegativeAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public double getAccountBalance(long id)
            throws IdNotValidException {
        try {
            if (!dao.isIdValid(id)) {
                throw new IdNotValidException(id);
            }
            return dao.getAccountBalance(id);
        } catch (IdNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void withdraw(double amount, Long id)
            throws InsufficientBalanceException, IdNotValidException {
            try {
                if (!dao.isIdValid(id)) {
                    throw new IdNotValidException(id);
                }
                if (dao.getAccountBalance(id) <= amount) {
                    throw new InsufficientBalanceException(amount, dao.getAccountBalance(id));
                }
                dao.withdraw(amount, id);
                double newBalance = dao.getAccountBalance(id);
                System.out.println("You have withdrawn the amount " + amount + ".\n The new balance is " + newBalance + ".");
            }catch (IdNotValidException | InsufficientBalanceException e) {
                e.printStackTrace();
                throw e;
            }
    }

    @Override
    public List<Account> getAccountsByOwner(long ownerId)
            throws IdNotValidException {
        return dao.getAccountsByOwner(ownerId);
    }


     /*
     * Mappers
     */
     private User mapFromInsert(UserInsertDTO userInsertDTO) {
         return new User(
                 userInsertDTO.getId(),
                 userInsertDTO.getFirstname(),
                 userInsertDTO.getLastname(),
                 userInsertDTO.getSsn());
     }

    private User mapFromUpdateDTO(UserUpdateDTO userUpdateDTO) {
        return new User(
                userUpdateDTO.getId(),
                userUpdateDTO.getFirstname(),
                userUpdateDTO.getLastname(),
                userUpdateDTO.getSsn());
    }

    private Account mapFromInsertDTO(AccountInsertDTO accountInsertDTO) {
        User user = mapFromInsert(accountInsertDTO.getUserInsertDTO());
        return new Account(
                accountInsertDTO.getId(),
                user,
                accountInsertDTO.getIban(),
                accountInsertDTO.getBalance()
        );
    }

    private Account mapFromUpdateDTO(AccountUpdateDTO accountUpdateDTO) {
        User user = mapFromUpdateDTO(accountUpdateDTO.getUserUpdateDTO());
        return new Account(
                accountUpdateDTO.getId(),
                user,
                accountUpdateDTO.getIban(),
                accountUpdateDTO.getBalance()
        );
    }


    private OverdraftAccount mapFromInsertDTO(OverdraftAccountInsertDTO overdraftAccountInsertDTO) {
        User user = mapFromInsert(overdraftAccountInsertDTO.getUserInsertDTO());
            return new OverdraftAccount(
                    overdraftAccountInsertDTO.getId(),
                    overdraftAccountInsertDTO.getOverdraftLimit(),
                    user,
                    overdraftAccountInsertDTO.getIban(),
                    overdraftAccountInsertDTO.getBalance()
            );
    }
}
