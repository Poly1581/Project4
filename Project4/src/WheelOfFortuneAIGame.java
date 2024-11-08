import java.util.ArrayList;
import java.util.List;

public class WheelOfFortuneAIGame extends WheelOfFortune{
    Integer activePlayer = 0;
    List<WheelOfFortunePlayer> players;

    public static void main(String[] args) {
        WheelOfFortuneAIGame AIGame = new WheelOfFortuneAIGame(List.of(new RandomGuesser(), new FrequencyGuesser()));
        AllGamesRecord gamesRecord = AIGame.playAll();
        System.out.println(gamesRecord);
    }

    public WheelOfFortuneAIGame() {
        players = new ArrayList<WheelOfFortunePlayer>();
        players.add(new RandomGuesser());
    }

    public WheelOfFortuneAIGame(WheelOfFortunePlayer player) {
        players = new ArrayList<WheelOfFortunePlayer>();
        players.add(player);
    }

    public WheelOfFortuneAIGame(List<WheelOfFortunePlayer> players) {
        this.players = players;
    }

    @Override
    public char getGuess() {
        return players.get(activePlayer).nextGuess(gameState);
    }

    @Override
    public String playerID() {
        return players.get(activePlayer).playerID();
    }
}