package gr.aueb.cf.myPractice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The program assures that the password:
 * Contains at least one lowercase.
 * Contains at least one uppercase.
 * Contains at least one number.
 * Contains at least one special character from the list: #?!@$%^&*-.
 * Has 8 characters minimum.
 **/

public class RegexPassword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        Pattern pattern = Pattern.compile("^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

        while (true) {
            System.out.println("Please enter a suitable password: ");
            password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);
            if (matcher.find()) {
                System.out.println("The password meets the prerequisites");
                break;
            } else {
                System.out.println("Τhe password does not meet the prerequisites.");
            }
        }


    }


}
