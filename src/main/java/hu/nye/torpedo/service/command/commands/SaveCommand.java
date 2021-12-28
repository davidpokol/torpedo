package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.persistance.jdbc.JdbcGameSavesRepository;
import hu.nye.torpedo.service.command.Command;
import hu.nye.torpedo.service.input.DataReader;

/**
 * This class managing the game state saving to the database.
 */
public class SaveCommand implements Command {

    private static final String PATTERN = "[1-9]";
    private final JdbcGameSavesRepository jdbcGameSavesRepository;
    private final GameState gameState;
    private final DataReader dataReader;

    /**
     * Class constructor.
     */
    public SaveCommand(JdbcGameSavesRepository jdbcGameSavesRepository, GameState gameState, DataReader dataReader) {
        this.jdbcGameSavesRepository = jdbcGameSavesRepository;
        this.gameState = gameState;
        this.dataReader = dataReader;
    }

    public static final String COMMAND = "SAVE";

    @Override
    public boolean canProcess(String input) {
        return COMMAND.equalsIgnoreCase(input);
    }

    @Override
    public void process(String input) {

        String saveId;
        do {

            System.out.println("Please enter the saveID: ");
            saveId = dataReader.readInput();

        } while (!saveId.matches(PATTERN));

        jdbcGameSavesRepository.save(gameState, saveId);
        System.out.println("Game saved!");
    }
}
