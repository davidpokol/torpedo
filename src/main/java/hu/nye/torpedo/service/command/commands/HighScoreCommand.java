package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import hu.nye.torpedo.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class responsible for showing the HIGH-SCORE table.
 */
public class HighScoreCommand implements Command {
    XmlHighScoreRepository xmlHighScoreRepository;

    public HighScoreCommand(XmlHighScoreRepository xmlHighScoreRepository) {

        this.xmlHighScoreRepository = xmlHighScoreRepository;
    }

    public static final Logger LOG = LoggerFactory.getLogger(ExitCommand.class);
    public static final String COMMAND = "highscore";

    @Override
    public boolean canProcess(String input) {
        return COMMAND.equalsIgnoreCase(input);
    }

    @Override
    public void process(String input) {
        xmlHighScoreRepository.writeOutHighScoreTable();
    }
}
