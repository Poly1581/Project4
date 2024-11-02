public abstract class Game {
    /**
     * play all games (while player wants to)
     * @return all game records from session
     */
    public AllGamesRecord playAll() {
        AllGamesRecord allGamesRecord = new AllGamesRecord();
        Boolean playNextGame = playNext();
        while(playNextGame) {
            allGamesRecord.add(play());
            playNextGame = playNext();
        }
        return allGamesRecord;
    }

    public abstract GameRecord play();
    public abstract Boolean playNext();
    public abstract String playerID();
}
