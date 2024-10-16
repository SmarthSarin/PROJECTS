/*Write a Java program for a two-player word guessing game, 
The game should begin by asking the first player to enter their name and a word for the second player to guess. 
Then, the second player should input their name, receive a welcome message, 
and start guessing the word letter by letter. The game should allow up to 10 incorrect guesses. 
Additionally, a 10-minute timer should be implemented, with a message displaying the remaining time every minute. 
If the player makes 10 incorrect guesses or the 10 minutes expire, they lose the game.” Also after every win or lose, 
you will switch the sides, for other player to play. */

import java.util.*;

public class WordGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1st player please enter your name: ");
        String word_giving_player = sc.nextLine();
        System.out.print("2nd player please enter your name: ");
        String guessing_player = sc.nextLine();
        while (true) { 
            System.out.print(word_giving_player + " please enter a word for " + guessing_player + " to guess: ");
            String word_to_guess = sc.nextLine();
            word_to_guess = word_to_guess.toLowerCase();

            System.out.println("Welcome " + word_giving_player + " and " + guessing_player + " to the Word Guessing Game!");
            System.out.println("The word to guess is consists " + word_to_guess.length() + " letters.");
            System.out.println("You have 10 chances and 10 minutes to guess the word.");
            System.out.println("You can guess the word letter by letter.");
            System.out.println("If you guess a letter correctly, it will be displayed in the correct position.");
            System.out.println("Let's start the game!!");
            System.out.println("------------------------------------------------");

            int incorrect_guesses = 0;
            int correct_guesses = 0;
            String guessed_word = "";
            for(int i=0; i<word_to_guess.length(); i++){
                guessed_word += "_";
            }

            final int[] timeRemainingWrapper = new int[]{600};
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    timeRemainingWrapper[0] -= 60;
                    System.out.println("Reminder !! Time remaining: " + timeRemainingWrapper[0] / 60 + " minutes");
                    if (timeRemainingWrapper[0] <= 0) {
                        System.out.println("Time's up! You lose.");
                        timer.cancel();
                    }
                }
            }, 60000, 60000);

            while(incorrect_guesses != 10 && timeRemainingWrapper[0] > 0){
                System.out.print("Guess a letter: ");
                char letter = sc.next().charAt(0);
                letter = Character.toLowerCase(letter);
                int index = word_to_guess.indexOf(letter);
                if(index != -1){
                    System.out.println("Correct guess! The letter " + letter + " is in the word.");
                    correct_guesses ++;
                    while(index != -1){
                        guessed_word = guessed_word.substring(0, index) + letter + guessed_word.substring(index + 1);
                        index = word_to_guess.indexOf(letter, index+1);
                    }
                    System.out.println(guessed_word);
                }else{
                    incorrect_guesses ++;
                    System.out.println("Oh no! You have made an incorrect guess.");
                    System.out.println("You are left with " + (10 - incorrect_guesses) + " chances to guess the word now.");
                }
                
                if(word_to_guess.equalsIgnoreCase(guessed_word)){
                    System.out.println("Congratulations " + guessing_player + " you guessed the word " + word_to_guess + " correctly in " + (correct_guesses + incorrect_guesses) + " guesses.");
                    break;
                }
            }
            timer.cancel();

            if (incorrect_guesses == 10 || timeRemainingWrapper[0] <= 0) {
                System.out.println("You lose. The word was " + word_to_guess);
            }

            System.out.print("Do you want to continue the game (y/n): ");
            char choice = sc.next().charAt(0);
            sc.nextLine();
            if(choice == 'y'){
                String temp = word_giving_player;
                word_giving_player = guessing_player;
                guessing_player = temp;
                System.out.println("Now " + word_giving_player + " will give the word and " + guessing_player + " will guess the word.");
            }else{
                break;
            }
        } 
    }
}