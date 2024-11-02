public class GameRecord implements Comparable<GameRecord> {
    private Integer score;
    private String playerID;

    /**
     * Constructor
     * @param score score to be assigned
     * @param playerID playerID to be assigned
     */
    public GameRecord(Integer score, String playerID) {
        this.score = score;
        this.playerID = playerID;
    }
}
