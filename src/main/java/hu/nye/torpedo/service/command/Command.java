package hu.nye.torpedo.service.command;

/**
 * Interface for commands.
 */
public interface Command {

    boolean canProcess(String input);

    void process(String input);
}
