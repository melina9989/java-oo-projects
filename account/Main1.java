package gr.aueb.cf.myPractice.account;

import gr.aueb.cf.myPractice.account.dao.AccountDAOImpl;
import gr.aueb.cf.myPractice.account.dto.*;
import gr.aueb.cf.myPractice.account.exceptions.IdNotValidException;
import gr.aueb.cf.myPractice.account.exceptions.InsufficientBalanceException;
import gr.aueb.cf.myPractice.account.exceptions.NegativeAmountException;
import gr.aueb.cf.myPractice.account.model.Account;
import gr.aueb.cf.myPractice.account.model.User;
import gr.aueb.cf.myPractice.account.service.AccountServiceImpl;

public class Main1 {
    public static void main(String[] args) throws NegativeAmountException, IdNotValidException {
        AccountDAOImpl accountDAO = new AccountDAOImpl();
        AccountServiceImpl accountService = new AccountServiceImpl(accountDAO);

        //Account creation

        UserInsertDTO user1 = new UserInsertDTO();
        user1.setFirstname("Όνομα");
        user1.setLastname("Επώνυμο");
        user1.setSsn("ΑΦΜ");

        AccountInsertDTO account1 = new AccountInsertDTO();
        account1.setUserInsertDTO(user1);
        account1.setId(1234L);
        account1.setBalance(200);
        account1.setIban("ijddwoaj");
        System.out.println(accountService.createAccount(account1));


        //Balance Update
        AccountUpdateDTO accountUpdateDTO =new AccountUpdateDTO();
        accountUpdateDTO.setBalance(600);


        accountService.getAccountBalance(1234L);

        System.out.println(accountService.getAccountBalance(1234L));



    }

}