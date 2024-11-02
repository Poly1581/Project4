public interface WheelOfFortunePlayer {
    Character nextGuess(WheelOfFortune.GameState gameState);
    String playerID();
    void reset();
}
