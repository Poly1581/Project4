import java.util.ArrayList;
import java.util.List;

public class AllGamesRecord {
    List<GameRecord> gameRecords = new ArrayList<GameRecord>();

    /**
     * Adds given gameRecord to list of gameRecords.
     * @param gameRecord gameRecord to be added
     */
    public void add(GameRecord gameRecord) {
        gameRecords.add(gameRecord);
    }

    /**
     * Compute average score (sum/count)
     * @return Double average of all scores
     */
    public Double average() {
        int totalScore = 0;
        for(GameRecord gameRecord : gameRecords) {
            totalScore += gameRecord.getScore();
        }
        return (double) totalScore / (double) gameRecords.size();
    }
}
