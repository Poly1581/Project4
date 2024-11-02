import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class WheelOfFortune extends Game {
    private class GameState {
        Integer guessesRemaining = 10;
        String previousGuesses = "";
        String remainingGuesses = "abcdefghijklmnopqrstuvwxyz";
        String phrase = randomPhrase();
        String hiddenPhrase = getHiddenPhrase(phrase, previousGuesses);
        Boolean lostGame = false;
        Boolean wonGame = false;
    }
    List<String> phrases = new ArrayList<String>();

    private String randomPhrase() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        String phrase =  phrases.get(rand.nextInt(phrases.size()));
        phrases.remove(phrase);
        return phrase;
    }

    private String getHiddenPhrase(String phrase, String previousGuesses) {
        StringBuilder hiddenPhrase = new StringBuilder();
        for(int i = 0; i < phrase.length(); i++) {
            Character c = phrase.charAt(i);
            if(Character.isWhitespace(c) || previousGuesses.indexOf(c) != -1) {
                hiddenPhrase.append(c);
            } else {
                hiddenPhrase.append('*');
            }
        }
        return hiddenPhrase.toString();
    }

    private void processGuess(GameState gameState, Character guess) {
        boolean correctGuess = gameState.phrase.indexOf(guess) != -1;
        gameState.previousGuesses += guess;
        if(correctGuess) {
            StringBuilder newRemainingGuesses = new StringBuilder(gameState.remainingGuesses);
            newRemainingGuesses.deleteCharAt(gameState.remainingGuesses.indexOf(guess));
            gameState.remainingGuesses = newRemainingGuesses.toString();
            gameState.hiddenPhrase = getHiddenPhrase(gameState.phrase, gameState.previousGuesses);
            gameState.wonGame = gameState.hiddenPhrase.indexOf('*') == -1;
        } else {
            gameState.lostGame = --gameState.guessesRemaining == 0;
        }
    }

    @Override
    public GameRecord play() {
        GameState gameState = new GameState();
        while(!gameState.lostGame && !gameState.wonGame) {
            char guess = getGuess(gameState.previousGuesses);
            processGuess(gameState, guess);
        }
        if(gameState.wonGame) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Womp womp, you lost.");
        }
        return new GameRecord(100 * gameState.guessesRemaining / new GameState().guessesRemaining, playerID());
    }

    @Override
    public Boolean playNext() {
        return !phrases.isEmpty();
    }

    public abstract String playerID();
    public abstract char getGuess(String previousGuesses);
}