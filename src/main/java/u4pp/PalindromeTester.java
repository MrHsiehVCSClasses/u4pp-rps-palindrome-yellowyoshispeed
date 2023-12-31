package u4pp;
/**
* YOUR COMMENTS HERE
*/
import java.util.Scanner;

public class PalindromeTester {
    /**
     * YOUR JAVADOC HERE
     */
    public static void execute(Scanner sc) {
        boolean isDoneTesting = false;
        boolean isDoneChecking = false;
        System.out.println("Welcome to Palindrome Tester");
        while (!isDoneTesting){ // checking if user is done
            isDoneChecking = false;
            System.out.print("Enter a phrase: ");
            String input = sc.nextLine();
            String temp = input; // makes a dupe (to be able to print)
            if (isPalindrome(input) == true){ // checks if it is or  not
                System.out.println(temp + " is a palindrome");
            } else{
                System.out.println(temp + " is not a palindrome");
            }
            while (!isDoneChecking) {
                System.out.print("Keep testing? (Y)es or (N)o: ");
                String check = sc.nextLine().toUpperCase();
                if (check.equals("Y")){
                    isDoneTesting = false;
                    isDoneChecking = true;
                }
                else if (check.equals("N")){
                    isDoneTesting = true;
                    isDoneChecking = true;
                }
                else{
                    System.out.println("Invalid Input, please try again");
                }
            }
        }


    }

    /**
     * YOUR JAVADOC HERE
     */
    public static boolean isPalindrome(String phrase) {
        String input = phrase.toUpperCase();
        String temp = "";
        input = input.replaceAll(" ", ""); // gets rid of spaces, and what ever is unecesssary
        input = input.replaceAll("\\d","");
        input = input.replaceAll("[^a-zA-Z0-9]", ""); // to be fair, I did copy the code for the special characters, but hey it saves space :p
        for (int i  = input.length() - 1; i >= 0; i--){
            temp = temp + input.charAt(i);// checks if it is real or not
        }

        if (input.equals(temp)){
            return true;
        }
        else{
            return false;
        }
    }

    /* Any helper methods you might need */
}