package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In case of wrong input, the DEFAULT COMMAND runs.
 */
public class DefaultCommand implements Command {

    public static final Logger LOG = LoggerFactory.getLogger(DefaultCommand.class);
    public static final String UNKNOWN_MESSAGE = "Unknown command";

    @Override
    public boolean canProcess(String input) {
        return true;
    }

    @Override
    public void process(String input) {
        LOG.info("Unknown command typed in");
        System.err.println(UNKNOWN_MESSAGE);

    }
}
