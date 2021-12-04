package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitCommand implements Command {

    private final GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    public static final Logger LOG = LoggerFactory.getLogger(ExitCommand.class);
    public static final String COMMAND = "EXIT";

    @Override
    public boolean canProcess(String input) {
        return COMMAND.equals(input.toUpperCase());
    }

    @Override
    public void process(String input) {
        gameState.setShouldExit(true);
    }
}
