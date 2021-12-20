package hu.nye.torpedo.configuration;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import hu.nye.torpedo.service.command.InputHandler;
import hu.nye.torpedo.service.game.GameCycle;
import hu.nye.torpedo.service.game.GameStepPerformer;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.ui.WinnerText;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for GAME manager classes.
 */
@Configuration
public class GameConfig {

    @Bean
    public GameStepPerformer gameStepPerformer(DataReader dataReader, InputHandler inputHandler) {
        return new GameStepPerformer(dataReader, inputHandler);
    }

    @Bean
    public GameCycle gameCycle(GameState gameState, XmlHighScoreRepository xmlHighScoreRepository,
                               WinnerText winnerText) {
        return new GameCycle(gameState, xmlHighScoreRepository, winnerText);
    }
}
