package hu.nye.torpedo.service.command.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hu.nye.torpedo.model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExitCommandTest {

    private static final String EXIT_COMMAND = "exit";
    private static final String NOT_EXIT_COMMAND = "not-exit";
    private GameState gameState;

    private ExitCommand underTest;

    @BeforeEach
    public void setUp() {

        gameState = new GameState(null, null, false);
        underTest = new ExitCommand(gameState);
    }

    @Test
    public void testCanProcessShouldReturnTrueWhenInputIsExit() {

        //Given in setup

        //When
        boolean result = underTest.canProcess(EXIT_COMMAND);

        //Then
        assertTrue(result);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenInputIsNotExit() {

        //Given in setup

        //When
        boolean result = underTest.canProcess(NOT_EXIT_COMMAND);

        //Then
        assertFalse(result);
    }

    @Test
    public void testProcessShouldChangeShouldExitFieldOfGameState() {

        //Given in setup

        //When
        underTest.process(EXIT_COMMAND);

        //Then
        assertTrue(gameState.isShouldExit());
    }
}
