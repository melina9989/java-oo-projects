package gr.aueb.cf.myPractice.account;

import gr.aueb.cf.myPractice.account.dao.AccountDAOImpl;
import gr.aueb.cf.myPractice.account.dto.*;
import gr.aueb.cf.myPractice.account.exceptions.IdNotValidException;
import gr.aueb.cf.myPractice.account.exceptions.InsufficientBalanceException;
import gr.aueb.cf.myPractice.account.exceptions.NegativeAmountException;
import gr.aueb.cf.myPractice.account.model.Account;
import gr.aueb.cf.myPractice.account.model.User;
import gr.aueb.cf.myPractice.account.service.AccountServiceImpl;

public class Main {
    public static void main(String[] args) throws NegativeAmountException, IdNotValidException {
        AccountDAOImpl accountDAO = new AccountDAOImpl();
        AccountServiceImpl accountService = new AccountServiceImpl(accountDAO);

        //Account creation

        UserInsertDTO user1 = new UserInsertDTO();
        user1.setId(1312L);
        user1.setFirstname("Όνομα");
        user1.setLastname("Επώνυμο");
        user1.setSsn("ΑΦΜ");

        AccountInsertDTO account1 = new AccountInsertDTO();
        account1.setUserInsertDTO(user1);
        account1.setId(1234L);
        account1.setBalance(200);
        account1.setIban("ijddwoaj");
        System.out.println(accountService.createAccount(account1));

//        //Account update
//        AccountUpdateDTO newDTO = new AccountUpdateDTO();
//        accountUpdateDTO.setBalance(300);
//        accountService.updateAccount(accountUpdateDTO);
//        System.out.println("Updated account:" + account1.toString());







        //OverdraftAccount creation for user1
        OverdraftAccountInsertDTO overdraftAccount = new OverdraftAccountInsertDTO();
        overdraftAccount.setUserInsertDTO(user1);
        overdraftAccount.setId(15273L);
        overdraftAccount.setBalance(100);
        overdraftAccount.setIban("ueueuee");
        overdraftAccount.setOverdraftLimit(500);
        System.out.println(accountService.createOverdraftAccount(overdraftAccount));



        //Prints the accounts belonging to the user1.
        System.out.println("The user1's accounts are:\n " + accountService.getAccountsByOwner(1312L));

        //Deposit to the OverdraftAccount
        accountService.deposit(15273L, 40);
        System.out.println(accountService.getAccountBalance(15273L));


        //withdrawal from the OverdraftAccount
        try {
            double amountToWithdraw = 50;
            accountService.withdraw(amountToWithdraw, 15273L);
            double balance = accountService.getAccountBalance(15273L);
            System.out.println("Το υπόλοιπο του λογαριασμού είναι: " + balance);
        } catch (IdNotValidException | InsufficientBalanceException e) {
            System.out.println("Σφάλμα κατά την εκτέλεση της ανάληψης: " + e.getMessage());
        }

    }

}
