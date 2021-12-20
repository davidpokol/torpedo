package hu.nye.torpedo.service.command.commands;

import java.util.List;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.persistance.jdbc.JdbcGameManager;
import hu.nye.torpedo.persistance.jdbc.JdbcGameSavesRepository;
import hu.nye.torpedo.service.command.Command;
import hu.nye.torpedo.service.input.DataReader;

/**
 * This class managing the game state loading from the database.
 */
public class LoadCommand implements Command {

    private final JdbcGameSavesRepository jdbcGameSavesRepository;
    private final JdbcGameManager jdbcGameManager;
    private final GameState gameState;
    private final DataReader dataReader;

    public LoadCommand(JdbcGameSavesRepository jdbcGameSavesRepository, JdbcGameManager jdbcGameManager,
                       GameState gameState, DataReader dataReader) {
        this.jdbcGameSavesRepository = jdbcGameSavesRepository;
        this.jdbcGameManager = jdbcGameManager;
        this.gameState = gameState;
        this.dataReader = dataReader;

    }

    public static final String COMMAND = "LOAD";

    @Override
    public boolean canProcess(String input) {
        return COMMAND.equals(input.toUpperCase());
    }

    @Override
    public void process(String input) {

        List<String> saves = jdbcGameManager.showGameSavesOfUser(gameState.getCurrentUserMap().getUserName());
        if (saves.size() == 0) {
            System.out.println("You don't have any saved games yet.");
        } else {
            String option = "";
            if (saves.size() == 1) {
                String name = gameState.getCurrentUserMap().getUserName();
                option = name + saves.get(0).charAt(name.length());

            } else {
                System.out.println(gameState.getCurrentUserMap().getUserName() + "'s saves: ");
                for (String id : saves) {
                    System.out.println(id);
                }

                do {
                    System.out.println("Which save would you like to load?");
                    option = dataReader.readInput();

                } while (!isValidSaveId(saves, option));

            }
            GameState loadedGameState = jdbcGameSavesRepository.load(option);
            gameState.setCurrentCpuMap(loadedGameState.getCurrentCpuMap());
            gameState.setCurrentUserMap(loadedGameState.getCurrentUserMap());
            System.out.println("Gamestate loaded!");
        }
    }

    private boolean isValidSaveId(List<String> saves, String option) {

        return saves.stream().anyMatch(a -> a.startsWith(option)) &&
                option.length() == (gameState.getCurrentUserMap().getUserName().length() + 1);
    }
}
