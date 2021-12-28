package hu.nye.torpedo.service.game;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.model.player.Players;
import hu.nye.torpedo.persistance.xml.XmlHighScoreManager;
import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import hu.nye.torpedo.ui.WinnerText;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameCycleTest {

    private static final String[][] MAP = new String[][] {
            {"0","0","1","0"},
            {"1","0","0","1"},
            {"1","0","0","1"},
            {"0","0","0","1"}
    };

    private static final boolean[][] SHIP_MAP_WITH_SHIPS = new boolean[][] {
            {false,false,true,false},
            {true,false,false,true},
            {true,false,false,true},
            {false,false,false,true}
    };

    private static final boolean[][] SHIP_MAP_WITHOUT_SHIPS = new boolean[][] {
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false}
    };
    private final JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);
    private final Marshaller marshaller = jaxbContext.createMarshaller();
    private final Players players = new Players();
    private final XmlHighScoreManager xmlHighScoreManager = new XmlHighScoreManager(players);
    private final XmlHighScoreRepository xmlHighScoreRepository = new XmlHighScoreRepository
            (players, marshaller, jaxbContext.createUnmarshaller(), xmlHighScoreManager);
    private final WinnerText winnerText = new WinnerText();

    private GameState gameState;
    private GameCycle underTest;

    @BeforeEach
    public void setUp() throws JAXBException {
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        gameState = null;
        underTest = null;
    }

    public GameCycleTest() throws JAXBException {
    }

    @Test
    public void testIsInGameShouldReturnTrueWhenThereIsStillShipsInGame() {

        //Given
        MapVO cpuMap = new MapVO(MAP, SHIP_MAP_WITH_SHIPS);
        UserMapVO userMap = new UserMapVO(MAP, SHIP_MAP_WITH_SHIPS,"name");
        gameState = new GameState (cpuMap,userMap, false);
        underTest = new GameCycle(gameState,xmlHighScoreRepository,winnerText);

        //When
        boolean actual = underTest.isInGame();

        //Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testIsInGameShouldReturnFalseWhenThereIsNoMoreShipsLeftInEitherMap() {

        //Given
        MapVO cpuMap = new MapVO(MAP, SHIP_MAP_WITHOUT_SHIPS);
        UserMapVO userMap = new UserMapVO(MAP, SHIP_MAP_WITHOUT_SHIPS,"name");
        gameState = new GameState (cpuMap,userMap, false);
        underTest = new GameCycle(gameState,xmlHighScoreRepository,winnerText);

        //When
        boolean actual = underTest.isInGame();

        //Then
        Assertions.assertFalse(actual);
    }

    @Test
    public void testIsInGameShouldReturnFalseWhenThereIsNoMoreShipsLeftInCPusMap() {

        //Given
        MapVO cpuMap = new MapVO(MAP, SHIP_MAP_WITHOUT_SHIPS);
        UserMapVO userMap = new UserMapVO(MAP, SHIP_MAP_WITH_SHIPS,"name");
        gameState = new GameState (cpuMap,userMap, false);
        underTest = new GameCycle(gameState,xmlHighScoreRepository,winnerText);

        //When
        boolean actual = underTest.isInGame();

        //Then
        Assertions.assertFalse(actual);
    }

    @Test
    public void testIsInGameShouldReturnFalseWhenThereIsNoMoreShipsLeftInUsersMap() {

        //Given
        MapVO cpuMap = new MapVO(MAP, SHIP_MAP_WITH_SHIPS);
        UserMapVO userMap = new UserMapVO(MAP, SHIP_MAP_WITHOUT_SHIPS,"name");
        gameState = new GameState (cpuMap,userMap, false);
        underTest = new GameCycle(gameState,xmlHighScoreRepository,winnerText);

        //When
        boolean actual = underTest.isInGame();

        //Then
        Assertions.assertFalse(actual);
    }

}
