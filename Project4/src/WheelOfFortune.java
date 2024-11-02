import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class WheelOfFortune extends Game {
    protected class GameState {
        private String phrase = randomPhrase();
        public Integer numGuessesRemaining = 10;
        public String previousGuesses = "";
        public String remainingGuesses = "abcdefghijklmnopqrstuvwxyz";
        public String hiddenPhrase = getHiddenPhrase(phrase, previousGuesses);
        public Boolean lostGame = false;
        public Boolean wonGame = false;
    }
    protected GameState gameState;
    List<String> phrases = new ArrayList<String>();

    private String randomPhrase() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        String phrase =  phrases.get(rand.nextInt(phrases.size()));
        phrases.remove(phrase);
        return phrase;
    }

    private static String getHiddenPhrase(String phrase, String previousGuesses) {
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
            gameState.lostGame = --gameState.numGuessesRemaining == 0;
        }
    }

    @Override
    public GameRecord play() {
        GameState gameState = new GameState();
        while(!gameState.lostGame && !gameState.wonGame) {
            char guess = getGuess();
            processGuess(gameState, guess);
        }
        if(gameState.wonGame) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Womp womp, you lost.");
        }
        return new GameRecord(100 * gameState.numGuessesRemaining / new GameState().numGuessesRemaining, playerID());
    }

    @Override
    public Boolean playNext() {
        return !phrases.isEmpty();
    }

    public abstract char getGuess();
}