package hu.nye.torpedo.service.game;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import hu.nye.torpedo.service.command.InputHandler;
import hu.nye.torpedo.service.input.DataReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for {@link GameStepPerformer}.
 */
@ExtendWith(MockitoExtension.class)
public class GameStepPerformerTest {

    private static final String INPUT = "input";

    @Mock
    private DataReader dataReader;

    @Mock
    private InputHandler inputHandler;

    private GameStepPerformer underTest;

    @BeforeEach
    public void setUp() {
        underTest = new GameStepPerformer(dataReader, inputHandler);
    }

    @Test
    public void testPerformGameStepShouldReadUserInputAndDelegateCallToInputHandler() {

        //Given
        given(dataReader.readInput()).willReturn(INPUT);

        //When
        underTest.performGameStep();

        //Then
        verify(dataReader).readInput();
        verify(inputHandler).handleInput(INPUT);
    }
}
