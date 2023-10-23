package u4pp;
import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
    public static void play(Scanner sc) {
        Random cpuChoice = new Random();
        boolean isGameOver = false; 
        boolean retryScreen = false;
        int win = 0;
        int lose = 0;
        int tie = 0;
        String choices = "RPS";
        System.out.println("Welcome to Rock Paper Scissors");
        
        while(!isGameOver){ // checks if the game is running or not
            char randomChar1 = choices.charAt(cpuChoice.nextInt(choices.length()));
            String s = String.valueOf(randomChar1);
            System.out.print("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny:");
            String player = sc.nextLine().toUpperCase();
            if (player.equals("A")){
                char randomChar2 = choices.charAt(cpuChoice.nextInt(choices.length()));
                player = String.valueOf(randomChar2);
            }
            if (results(player,s) == 1){ // this entire portion checks who won
                retryScreen = true;
                System.out.print(translate(player,s) + ". You win!");
                win++;
                System.out.print("\nYou have " + win + " wins and " + lose + " loses and " + tie + " ties");
                while (retryScreen){
                    System.out.print("\nWould you like to play again? (Y)es or (N)o: ");
                    String input = sc.nextLine().toUpperCase();
                    if (cont(input) == 1){
                    retryScreen = false;
                    isGameOver = false;
                    }
                    else if (cont(input) == 2){
                        retryScreen = false;
                        isGameOver = true;
                        System.out.print("Thanks for playing!");
                        return;
                    }
                    else{
                        System.out.print("Invalid input, please try again");
                    }
                }
            }
            else if (results(player,s) == -1) {
                retryScreen = true;
                System.out.print(translate(player,s) + ". You lose!");
                lose++;
                System.out.print("\nYou have " + win + " wins and " + lose + " loses and " + tie + " ties");
                while (retryScreen){
                    System.out.print("\nWould you like to play again? (Y)es or (N)o: ");
                    String input = sc.nextLine().toUpperCase();
                    if (cont(input) == 1){
                    retryScreen = false;
                    isGameOver = false;
                    }
                    else if (cont(input) == 2){
                        retryScreen = false;
                        isGameOver = true;
                        System.out.print("Thanks for playing!");
                        return;
                    }
                    else{
                        System.out.print("Invalid input, please try again");
                    }
                }
                
            }
            else if (results(player,s) == 0){
                retryScreen = true;
                System.out.print(translate(player,s) + ". it's a tie");
                tie++;
                System.out.print("\nYou have " + win + " wins and " + lose + " loses and " + tie + " ties");
                while (retryScreen){
                    System.out.print("\nWould you like to play again? (Y)es or (N)o: ");
                    String input = sc.nextLine().toUpperCase();
                    if (cont(input) == 1){
                    retryScreen = false;
                    isGameOver = false;
                    }
                    else if (cont(input) == 2){
                        retryScreen = false;
                        isGameOver = true;
                        System.out.print("Thanks for playing!");
                        return;
                    }
                    else{
                        System.out.print("Invalid input, please try again");
                    }
                }

            }
            else{
                System.out.println("Invalid input, please try again"); // Here just in case, you know?
            }

            
        }
    }

    /**
     * JAVADOC HERE
     */
    public static int results(String playerChoice, String computerChoice) { // checks who wins, returns int
        if (playerChoice.equals("R")){
            if (computerChoice.equals("R")){
                return 0; // tie
            }
            else if (computerChoice.equals("P")){
                return -1; // lose
            }
            else if (computerChoice.equals("S")){
                return 1; // win
            }
        }
        else if (playerChoice.equals("P")){
            if (computerChoice.equals("R")){
                return 1;
            }
            else if (computerChoice.equals("P")){
                return 0;
            }
            else{
                return -1;
            }
        }
        else if (playerChoice.equals("S")){
            if (computerChoice.equals("R")){
                return -1;
            }
            else if (computerChoice.equals("P")){
                return 1;
            }
            else{
                return 0;
            }
        }
        return 3;
        

    }

    public static int cont(String input){ // gets input to see if they want to continue
        if (input.equals("Y")){
            return 1;
        }
        else if (input.equals("N")){
            return 2;
        }else{
            return 99;
        }
        
    }

    public static String translate(String player,String s){ // literally just here to make printing easier lol.
        if (player.equals("R")){
            if (s.equals("R")){
                return "You both picked Rock";
            }
            else if (s.equals("P")){
                return "You picked Rock, and the Computer picked Paper";
            }
            else if (s.equals("S")){
                return "You picked Rock, and the Computer picked Scissors";
            }
        }
        else if (player.equals("P")){
            if (s.equals("R")){
                return "You picked Paper, and the Computer picked Rock";
            }
            else if (s.equals("P")){
                return "You both picked Paper";
            }
            else if (s.equals("S")){
                return "You picked Paper, and the Computer picked Scissors";
            }
        }
        else if (player.equals("S")){
            if (s.equals("R")){
                return "You picked Scissors, and the Computer picked Rock";
            }
            else if (s.equals("P")){
                return "You picked Scissors, and the Computer picked Paper";
            }
            else if (s.equals("S")){
                return "You both picked Scissors";
            }
        }
        return "Invalid Input, please try again";
    }
    /* any helper methods you might need */
}