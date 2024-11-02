import com.sun.source.tree.Tree;

import java.util.*;

public class AllGamesRecord {
    Integer numberOfGames = 0;
    SortedMap<String, List<GameRecord>> playerGames = new TreeMap<String, List<GameRecord>>();

    /**
     * Adds given gameRecord to list of gameRecords.
     * @param gameRecord gameRecord to be added
     */
    public void add(GameRecord gameRecord) {
        numberOfGames++;
        String id = gameRecord.getPlayerID();
        if(playerGames.containsKey(id)) {
            playerGames.get(id).add(gameRecord);
        } else {
            playerGames.put(id, new ArrayList<GameRecord>(List.of(gameRecord)));
        }
    }

    /**
     * Compute average score (sum/count) of all games
     * @return Double average of all scores
     */
    public Double average() {
        Double totalScore = 0.0;
        for(String playerID : playerGames.keySet()) {
            for(GameRecord playerGameRecord : playerGames.get(playerID)) {
                totalScore++;
            }
        }
        return totalScore / numberOfGames;
    }

    /**
     * Compute average score (sum/count) of all of a players games.
     * @param playerID the player whose average is to be calculated
     * @return average of playerID's games
     */
    public Double average(String playerID) {
        Double totalScore = 0.0;
        List<GameRecord> playerGameRecords = playerGames.get(playerID);
        for(GameRecord playerGameRecord : playerGameRecords) {
            totalScore += playerGameRecord.getScore();
        }
        return totalScore / playerGameRecords.size();
    }
    
    public List<GameRecord> highGameList(Integer n) {

    }

    /**
     * Get player's n highest games by score.
     * @param playerID the player whose scores are to be returned
     * @param n how many scores are to be returned
     * @return a list of n of playerID's highest games
     */
    public List<GameRecord> highGameList(String playerID, Integer n) {
        List<GameRecord> playerGameRecords = playerGames.get(playerID);
        return playerGameRecords.subList(0, Math.max(n, playerGameRecords.size()));
    }
}
