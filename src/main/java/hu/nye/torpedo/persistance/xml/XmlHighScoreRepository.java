package hu.nye.torpedo.persistance.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import hu.nye.torpedo.model.player.Player;
import hu.nye.torpedo.model.player.Players;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * Managing the high-score.xml file.
 */
public class XmlHighScoreRepository {

    private final Players players;
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final XmlHighScoreManager xmlHighScoreManager;

    private static final String FILE_NAME = "highscore.xml";

    public XmlHighScoreRepository(Players players, Marshaller marshaller, Unmarshaller unmarshaller,
                                  XmlHighScoreManager xmlHighScoreManager) {
        this.players = players;
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
        this.xmlHighScoreManager = xmlHighScoreManager;
    }

    /**
     * Updates the highscore.xml file.
     */
    public void update(String winnerName) {

        load();
        xmlHighScoreManager.addHighScore(winnerName);
        writeToXml();

    }

    /**
     * Shows a high-score table on the console.
     */
    public void writeOutHighScoreTable() {
        load();
        for (Player player : players.getPlayers()) {
            System.out.println("Name: " + player.getName() + ", games won:" + player.getGamesWon());
        }
    }

    private void load() {
        try {

            Players highScore = (Players) unmarshaller.unmarshal(new File(FILE_NAME));

            List<Player> newHighScore = new ArrayList<>(highScore.getPlayers());
            players.setPlayers(newHighScore);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void writeToXml() {
        try {

            marshaller.marshal(players, new File(FILE_NAME));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
