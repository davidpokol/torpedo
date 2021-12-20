package hu.nye.torpedo.persistance.xml;

import java.util.ArrayList;
import java.util.List;

import hu.nye.torpedo.model.player.Player;
import hu.nye.torpedo.model.player.Players;

/**
 * Helps in XML file managing.
 */
public class XmlHighScoreManager {

    private final Players players;

    public XmlHighScoreManager(Players players) {
        this.players = players;
    }

    protected void addHighScore(String winnerName) {

        if (isNewWinner(winnerName)) {

            List<Player> newHighScore = new ArrayList<>(players.getPlayers());
            newHighScore.add(new Player(winnerName, 1));
            players.setPlayers(newHighScore);

        } else {
            int index = getIndexOfWinner(winnerName);
            int newGamesWon = players.getPlayers().get(index).getGamesWon() + 1;
            players.getPlayers().get(index).setGamesWon(newGamesWon);
        }
    }

    private boolean isNewWinner(String winnerName) {

        boolean result = true;
        for (Player player : players.getPlayers()) {
            if (player.getName().equalsIgnoreCase(winnerName)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private int getIndexOfWinner(String winnerName) {

        int index = -1;
        for (int i = 0; i < players.getPlayers().size(); i++) {

            if (players.getPlayers().get(i).getName().equalsIgnoreCase(winnerName)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

