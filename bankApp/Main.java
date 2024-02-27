package gr.aueb.cf.myPractice.bankApp;
import gr.aueb.cf.myPractice.bankApp.model.*;

/**
 * Tests the functionality of {@link OverdraftAccount} class
 * and {@link JointAccount} class.
 */
public class Main {
    public static void main(String[] args) {
        OverdraftAccount account = new OverdraftAccount(1, "GR123", "A103", 1000.0);

        JointAccount jointAccount = new JointAccount(account, "John", "George");
        try {
            account.deposit(500);
            System.out.println("Successful deposit");

            account.withdraw(1000, "A103");
            System.out.println("Successful withdraw");
            System.out.println(account.accountToString());

            System.out.println(jointAccount.toString());

        } catch (Exception e) {
            e.getMessage();
        }




    }
}
