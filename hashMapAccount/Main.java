package gr.aueb.cf.myPractice.hashMapAccount;

import gr.aueb.cf.myPractice.hashMapAccount.dao.AccountDAOImpl;
import gr.aueb.cf.myPractice.hashMapAccount.dto.*;
import gr.aueb.cf.myPractice.hashMapAccount.exceptions.IdNotValidException;
import gr.aueb.cf.myPractice.hashMapAccount.exceptions.InsufficientBalanceException;
import gr.aueb.cf.myPractice.hashMapAccount.exceptions.NegativeAmountException;
import gr.aueb.cf.myPractice.hashMapAccount.service.AccountServiceImpl;

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
        System.out.println(accountService.createAccount(account1.getId(), account1));

//        //Account update
//        AccountUpdateDTO accountUpdateDTO = new AccountUpdateDTO();
//        accountUpdateDTO.setBalance(300);
//        accountService.updateAccount(account1, accountUpdateDTO );
//        System.out.println("Updated account:" + account1.toString());







        //OverdraftAccount creation for user1
        OverdraftAccountInsertDTO overdraftAccount = new OverdraftAccountInsertDTO();
        overdraftAccount.setUserInsertDTO(user1);
        overdraftAccount.setId(15273L);
        overdraftAccount.setBalance(100);
        overdraftAccount.setIban("ueueuee");
        overdraftAccount.setOverdraftLimit(500);
        System.out.println(accountService.createOverdraftAccount(overdraftAccount.getId(), overdraftAccount));



        //JointAccount creation for user1 with user2
        JointAccountInsertDTO jointAccount = new JointAccountInsertDTO();
        jointAccount.setUserInsertDTO(user1);
        jointAccount.setId(2708L);
        jointAccount.setBalance(700);
        jointAccount.setIban("ibanJointAccount");

        // Create the UserInsertDTO for the second holder
        UserInsertDTO secondHolderInsertDTO = new UserInsertDTO();
        secondHolderInsertDTO.setFirstname("Όνομα2");
        secondHolderInsertDTO.setLastname("Επώνυμο2");
        secondHolderInsertDTO.setSsn("ΑΦΜ2");
        secondHolderInsertDTO.setId(1530L);

        jointAccount.setSecondHolderInsertDTO(secondHolderInsertDTO);

        System.out.println(accountService.createJointAccount(jointAccount.getId(), jointAccount));


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

        System.out.println("Οι λογαριασμοι του χρηστη με id:1312 ειναι: " + accountService.getAccountsByOwner(1312L));

    }

}
