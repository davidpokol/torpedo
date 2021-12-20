package hu.nye.torpedo.configuration;

import hu.nye.torpedo.service.ship.ShipGenerator;
import hu.nye.torpedo.service.ship.ShipPlacer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for SHIP classes.
 */
@Configuration
public class ShipConfig {

    @Bean
    public ShipPlacer shipPlacer() {
        return new ShipPlacer();
    }

    @Bean
    public ShipGenerator shipGenerator() {
        return new ShipGenerator();
    }
}
