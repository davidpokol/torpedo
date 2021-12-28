package hu.nye.torpedo.service.command.commands;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.ui.MapDisplayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShowCommandTest {

    private static final String SHOW_COMMAND = "show";
    private static final String NOT_SHOW_COMMAND = "not-show";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final String[][] UserMap = {{"0", "0"}, {"0", "0"}};
    private final boolean[][] UserShipMap = {{false, false}, {true, false}};
    private final String[][] cpuMap = {{"0", "0"}, {"0", "0"}};
    private final boolean[][] cpuShipMap = {{false, false}, {false, true}};

    private final GameState gameState = new GameState(new MapVO(cpuMap, cpuShipMap),
            new UserMapVO(UserMap, UserShipMap, "name"), false);
    private final MapDisplayer mapDisplayer = new MapDisplayer(gameState);
    private final ShowCommand underTest = new ShowCommand(mapDisplayer);


    @Test
    public void testCanProcessShouldReturnTrueWhenTheGivenCommandIsPrint() {

        //Given

        //When
        boolean result = underTest.canProcess(SHOW_COMMAND);

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheGivenCommandIsNotPrint() {

        //Given

        //When
        boolean result = underTest.canProcess(NOT_SHOW_COMMAND);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testProcessShouldPrintTheCurrentMapFromGameState() {

        //Given
        System.setOut(new PrintStream(outContent));

            //using CRLF line separator
        String expected = "USER'S MAP\r\n" +
                "   1 2\r\n" +
                "A| 0 0\r\n" +
                "B| 0 0\r\n" +
                "\r\n" +
                "CPU'S MAP\r\n" +
                "   1 2\r\n" +
                "A| 0 0\r\n" +
                "B| 0 0";

        //When
        underTest.process(SHOW_COMMAND);

        //Then
        Assertions.assertEquals(expected, outContent.toString().trim());
    }
}
