package hu.nye.torpedo.configuration;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.player.Player;
import hu.nye.torpedo.service.game.GameController;
import hu.nye.torpedo.service.game.GameManager;
import hu.nye.torpedo.service.game.GameStepPerformer;
import hu.nye.torpedo.service.input.MapReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for APPLICATION classes.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public GameManager gameManager(GameState gameState) {
        return new GameManager(gameState);
    }

    @Bean
    public GameController gameController(GameState gameState, GameStepPerformer gameStepPerformer) {
        return new GameController(gameState, gameStepPerformer);
    }

    @Bean
    public MapReader mapReader() {
        return new MapReader();
    }
}
