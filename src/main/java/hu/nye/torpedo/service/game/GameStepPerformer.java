package hu.nye.torpedo.service.game;

import hu.nye.torpedo.service.command.InputHandler;
import hu.nye.torpedo.service.input.DataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When the user type in a command, this class performs it.
 */
public class GameStepPerformer {

    private static final Logger LOG = LoggerFactory.getLogger(GameStepPerformer.class);

    private final DataReader fileReader;
    private final InputHandler inputHandler;

    /**
     *Class constructor
     */
    public GameStepPerformer(DataReader fileReader, InputHandler inputHandler) {
        this.fileReader = fileReader;
        this.inputHandler = inputHandler;
    }

    /**
     * Performs a game step.
     */
    public void performGameStep() {
        String input = fileReader.readInput();
        LOG.info("Read user input = '{}'", input);
        inputHandler.handleInput(input);
    }
}
