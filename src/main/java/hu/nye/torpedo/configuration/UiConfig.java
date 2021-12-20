package hu.nye.torpedo.configuration;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.ui.MapDisplayer;
import hu.nye.torpedo.ui.WinnerText;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for UI classes.
 */
@Configuration
public class UiConfig {

    @Bean
    public MapDisplayer mapDisplayer(GameState gameState) {
        return new MapDisplayer(gameState);
    }

    @Bean
    public WinnerText winnerText() {
        return new WinnerText();
    }
}
