package hu.nye.torpedo.service.command.commands;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import hu.nye.torpedo.model.player.Player;
import hu.nye.torpedo.model.player.Players;
import hu.nye.torpedo.persistance.xml.XmlHighScoreManager;
import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HighScoreCommandTest {

    private static final String HIGH_SCORE_COMMAND = "highscore";
    private static final String NOT_HIGH_SCORE_COMMAND = "not-highscore";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);
    private final Marshaller marshaller = jaxbContext.createMarshaller();
    Players players = new Players();
    private final XmlHighScoreManager xmlHighScoreManager = new XmlHighScoreManager(players);
    private final XmlHighScoreRepository xmlHighScoreRepository = new XmlHighScoreRepository
            (players,marshaller,jaxbContext.createUnmarshaller(),xmlHighScoreManager);

    @BeforeEach
    public void setUp() throws JAXBException {
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    private final HighScoreCommand underTest = new HighScoreCommand(xmlHighScoreRepository);

    public HighScoreCommandTest() throws JAXBException {
    }

    @Test
    public void testCanProcessShouldReturnTrueWhenTheGivenCommandIsPrint() {

        //Given

        //When
        boolean result = underTest.canProcess(HIGH_SCORE_COMMAND);

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheGivenCommandIsNotPrint() {

        //Given

        //When
        boolean result = underTest.canProcess(NOT_HIGH_SCORE_COMMAND);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testProcessShouldPrintTheCurrentMapFromGameState() {

        //Given
        System.setOut(new PrintStream(outContent));
        StringBuilder expected = new StringBuilder();

        //When
        underTest.process(HIGH_SCORE_COMMAND);

        for(Player player: players.getPlayers()) {
            //using CRLF line separator
            expected.append("Name: ")
                    .append(player.getName())
                    .append(", games won:")
                    .append(player.getGamesWon())
                    .append("\r\n");
        }

        //Then
        Assertions.assertEquals(expected.toString(), outContent.toString());
    }
}
