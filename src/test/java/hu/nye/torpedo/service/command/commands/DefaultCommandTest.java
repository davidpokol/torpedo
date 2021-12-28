package hu.nye.torpedo.service.command.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultCommandTest {

    private static final String INPUT = "";
    private static final String UNKNOWN_COMMAND_MESSAGE = "Unknown command";
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private DefaultCommand underTest = new DefaultCommand();

    @Test
    public void testCanProcessShouldAlwaysReturnTrue() {

        //Given

        //When
        boolean result = underTest.canProcess(INPUT);

        //Then
        assertTrue(result);
    }

    @Test
    public void testProcessShouldPrintUnknownCommand() {

        // Given
        System.setErr(new PrintStream(errContent));

        // When
        underTest.process(INPUT);

        //Then
        Assertions.assertEquals(UNKNOWN_COMMAND_MESSAGE, errContent.toString().trim());
    }
}
