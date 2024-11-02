import java.util.*;

public class AllGamesRecord {
    TreeSet<GameRecord> allGames = new TreeSet<GameRecord>();
    Map<String, TreeSet<GameRecord>> playerGames = new HashMap<String, TreeSet<GameRecord>>();

    /**
     * Adds given gameRecord to list of gameRecords.
     * @param gameRecord gameRecord to be added
     */
    public void add(GameRecord gameRecord) {
        allGames.add(gameRecord);
        String id = gameRecord.getPlayerID();
        if(playerGames.containsKey(id)) {
            playerGames.get(id).add(gameRecord);
        } else {
            playerGames.put(id, new TreeSet<GameRecord>(List.of(gameRecord)));
        }
    }

    /**
     * Helper method to compute the sum of a given set of gameRecords
     * @param gameRecords a set of game records
     * @return the average of all GameRecords in gameRecords
     */
    private static Double average(TreeSet<GameRecord> gameRecords) {
        Double totalScore = 0.0;
        for(GameRecord gameRecord : gameRecords) {
            totalScore += gameRecord.getScore();
        }
        return totalScore / gameRecords.size();
    }

    /**
     * Compute average score (sum/count) of all games
     * @return Double average of all scores
     */
    public Double average() {
        return average(allGames);
    }

    /**
     * Compute average score (sum/count) of all of a players games.
     * @param playerID the player whose average is to be calculated
     * @return average of playerID's games
     */
    public Double average(String playerID) {
        return average(playerGames.get(playerID));
    }

    /**
     * Helper method to get highest n games from a given sorted set
     * @param gameRecords a sorted (by nature of) TreeSet of GameRecords
     * @param n the number of highest games to return
     * @return the n (capped at size of gameRecords) highest games from gameRecords
     */
    private static List<GameRecord> highGameList(TreeSet<GameRecord> gameRecords, int n) {
        List<GameRecord> highGames = new ArrayList<GameRecord>();
        GameRecord highestGame = gameRecords.last();
        while(highGames.size() < n && highestGame != null) {
            highGames.add(highestGame);
            highestGame = gameRecords.lower(highestGame);
        }
        return highGames;
    }

    /**
     * Get n highest games (if n > number of games), return all games, sorted
     * @param n the number of games to return
     * @return the (sorted) list of
     */
    public List<GameRecord> highGameList(Integer n) {
        return highGameList(allGames, allGames.size());
    }

    /**
     * Get player's n highest games by score.
     * @param playerID the player whose scores are to be returned
     * @param n how many scores are to be returned
     * @return a list of n of playerID's highest games
     */
    public List<GameRecord> highGameList(String playerID, Integer n) {
        TreeSet<GameRecord> playerGameRecords = playerGames.get(playerID);
        return highGameList(playerGameRecords, n);
    }
}