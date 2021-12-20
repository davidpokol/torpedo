package hu.nye.torpedo.configuration;


import java.util.List;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.persistance.jdbc.JdbcGameManager;
import hu.nye.torpedo.persistance.jdbc.JdbcGameSavesRepository;
import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import hu.nye.torpedo.service.command.Command;
import hu.nye.torpedo.service.command.InputHandler;
import hu.nye.torpedo.service.command.commands.DefaultCommand;
import hu.nye.torpedo.service.command.commands.ExitCommand;
import hu.nye.torpedo.service.command.commands.HighScoreCommand;
import hu.nye.torpedo.service.command.commands.LoadCommand;
import hu.nye.torpedo.service.command.commands.SaveCommand;
import hu.nye.torpedo.service.command.commands.ShootCommand;
import hu.nye.torpedo.service.command.commands.ShowCommand;
import hu.nye.torpedo.service.game.GameCycle;
import hu.nye.torpedo.service.game.GameManager;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.util.CpuPointGeneratorUtil;
import hu.nye.torpedo.service.util.PointValidatorUtil;
import hu.nye.torpedo.service.util.ShipReferenceUtil;
import hu.nye.torpedo.ui.MapDisplayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for COMMAND classes.
 */
@Configuration
public class CommandConfig {

    @Bean
    public InputHandler inputHandler(List<Command> commands) {
        return new InputHandler(commands);
    }

    @Bean
    public ShootCommand shootCommand(GameState gameState, GameManager gameManager, DataReader dataReader,
                                     ShipReferenceUtil shipReferenceUtil, CpuPointGeneratorUtil cpuPointGenerator,
                                     MapDisplayer mapDisplayer, PointValidatorUtil pointValidator, GameCycle gameCycle,
                                     ShowCommand showCommand) {
        return new ShootCommand(gameState, gameManager, dataReader, shipReferenceUtil, cpuPointGenerator,
                 pointValidator, gameCycle, showCommand);
    }

    @Bean
    public SaveCommand saveCommand(JdbcGameSavesRepository jdbcGameSavesRepository, GameState gameState,
                                   DataReader dataReader) {
        return new SaveCommand(jdbcGameSavesRepository, gameState, dataReader);
    }

    @Bean
    public LoadCommand loadCommand(JdbcGameSavesRepository jdbcGameSavesRepository, JdbcGameManager jdbcGameManager,
                                   GameState gameState, DataReader dataReader) {
        return new LoadCommand(jdbcGameSavesRepository, jdbcGameManager, gameState, dataReader);
    }

    @Bean
    public ShowCommand showCommand(MapDisplayer mapDisplayer) {
        return new ShowCommand(mapDisplayer);
    }

    @Bean
    public HighScoreCommand highScoreCommand(XmlHighScoreRepository xmlHighScoreRepository) {
        return new HighScoreCommand(xmlHighScoreRepository);
    }

    @Bean
    public ExitCommand exitCommand(GameState gameState) {
        return new ExitCommand(gameState);
    }

    @Bean
    public DefaultCommand defaultCommand() {
        return new DefaultCommand();
    }
}
