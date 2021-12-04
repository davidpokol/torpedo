package hu.nye.torpedo.configuration;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.ui.MapDisplayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UiConfig {

    @Bean
    public MapDisplayer mapDisplayer(GameState gameState) {
        return new MapDisplayer(gameState);
    }

}
