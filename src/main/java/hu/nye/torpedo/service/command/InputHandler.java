package hu.nye.torpedo.service.command;

import java.util.List;


public class InputHandler {

    private final List<Command> commands;

    public InputHandler(List<Command> commands) {
        this.commands = commands;
    }

    public void handleInput(String input) {

        for (Command command : commands) {
            if (command.canProcess(input)) {
                command.process(input);
                break;
            }
        }
    }
}
