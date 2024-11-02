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

    /**
     * Score getter
     * @return score of the GameRecord
     */
    public Integer getScore() {
        return score;
    }

    /**
     * PlayerID getter
     * @return playerID of the GameRecord
     */
    public String getPlayerID() {
        return playerID;
    }
}
