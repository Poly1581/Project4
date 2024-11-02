import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFortune {
    private Scanner userInput = new Scanner(System.in);
    @Override
    public String playerID() {
        System.out.println("Please enter your player ID:");
        return userInput.next();
    }

    public void promptGuess() {
        System.out.println(gameState.numGuessesRemaining + " guesses remain, phrase is:");
        System.out.println(gameState.hiddenPhrase);
        System.out.println("Remaining letters: ");
        for(int i = 0; i < gameState.remainingGuesses.length(); i++) {
            char remainingGuess = gameState.remainingGuesses.charAt(i);
            System.out.println(remainingGuess + " ");
        }
        System.out.println();
        System.out.println("Which letter would you like to guess?");
    }

    @Override
    public char getGuess() {
        char guess;
        boolean invalidGuess;
        do {
            promptGuess();
            guess = Character.toLowerCase(userInput.next().charAt(0));
            boolean guessIsLetter = Character.isLetter(guess);
            if(!guessIsLetter) {
                System.out.println("Guess must be a letter, please try again.");
            }
            boolean alreadyGuessed = gameState.remainingGuesses.indexOf(guess) != -1;
            if(alreadyGuessed) {
                System.out.println(guess + " has already been guessed, please guess again.");
            }
            invalidGuess = !guessIsLetter || alreadyGuessed;
        } while(invalidGuess);
        return guess;
    }

    @Override
    public Boolean playNext() {
        if(phrases.isEmpty()) {
            return false;
        }
        System.out.println("Would you like to play wheel of fortune?");
        System.out.println("Enter 'yes' to play");
        return userInput.next().toLowerCase() == "yes";
    }
}
