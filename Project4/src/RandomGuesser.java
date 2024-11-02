import java.util.Random;
public class RandomGuesser implements WheelOfFortunePlayer {
    @Override
    public Character nextGuess(WheelOfFortune.GameState gameState) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        return gameState.remainingGuesses.charAt(rand.nextInt(gameState.remainingGuesses.length()));
    }

    @Override
    public String playerID() {
        return "Random Guesser AI";
    }

    @Override
    public void reset() {

    }
}
