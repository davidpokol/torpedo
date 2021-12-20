package hu.nye.torpedo.service.command;

import java.util.List;

import hu.nye.torpedo.service.exeption.XmlException;

/**
 * This class handles the input commands.
 */
public class InputHandler {

    private final List<Command> commands;

    public InputHandler(List<Command> commands) {
        this.commands = commands;
    }

    /**
     * This method manages the commands, typed in by the user.
     */
    public void handleInput(String input) {

        for (Command command : commands) {
            if (command.canProcess(input)) {
                command.process(input);
                break;
            }
        }
    }
}
