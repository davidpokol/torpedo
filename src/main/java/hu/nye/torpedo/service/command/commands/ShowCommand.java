package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.service.command.Command;
import hu.nye.torpedo.ui.MapDisplayer;

/**
 * Shows the current USER and CPU map.
 */
public class ShowCommand implements Command {

    private final MapDisplayer mapDisplayer;

    public ShowCommand(MapDisplayer mapDisplayer) {
        this.mapDisplayer = mapDisplayer;
    }

    public static final String COMMAND = "SHOW";

    @Override
    public boolean canProcess(String input) {
        return COMMAND.equals(input.toUpperCase());
    }

    @Override
    public void process(String input) {
        mapDisplayer.showGameState();
    }
}
