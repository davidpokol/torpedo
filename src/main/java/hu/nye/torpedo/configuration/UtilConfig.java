package hu.nye.torpedo.configuration;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.input.MapReader;
import hu.nye.torpedo.service.ship.ShipGenerator;
import hu.nye.torpedo.service.ship.ShipPlacer;
import hu.nye.torpedo.service.util.CpuPointGeneratorUtil;
import hu.nye.torpedo.service.util.FileDataValidatorUtil;
import hu.nye.torpedo.service.util.FileManagerUtil;
import hu.nye.torpedo.service.util.MapToStringUtil;
import hu.nye.torpedo.service.util.MapUnwrapperUtil;
import hu.nye.torpedo.service.util.MapUtil;
import hu.nye.torpedo.service.util.MapVoInitUtil;
import hu.nye.torpedo.service.util.PointValidatorUtil;
import hu.nye.torpedo.service.util.ShipReferenceUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for UTIL classes.
 */
@Configuration
public class UtilConfig {

    @Bean
    public CpuPointGeneratorUtil cpuPointGeneratorUtil(GameState gameState) {
        return new CpuPointGeneratorUtil(gameState);
    }

    @Bean
    public FileDataValidatorUtil fileDataValidator() {
        return new FileDataValidatorUtil();
    }

    @Bean
    public FileManagerUtil fileManager() {
        return new FileManagerUtil();
    }

    @Bean
    MapToStringUtil mapConverterUtil(MapUtil mapUtil) {
        return new MapToStringUtil(mapUtil);
    }

    @Bean
    public MapUtil mapUtil() {
        return new MapUtil();
    }

    @Bean
    public PointValidatorUtil pointValidator() {
        return new PointValidatorUtil();
    }

    @Bean
    public ShipReferenceUtil shipReferenceUtil() {
        return new ShipReferenceUtil();
    }

    @Bean
    public MapUnwrapperUtil mapUnwrapperUtil() {
        return new MapUnwrapperUtil();
    }

    @Bean
    public MapVoInitUtil initUtil(MapReader mapReader, FileDataValidatorUtil fileDataValidatorUtil, FileManagerUtil
            fileManagerUtil, MapUtil mapUtil, DataReader dataReader, ShipGenerator shipGenerator,
                                  ShipPlacer shipPlacer) {
        return new MapVoInitUtil(mapReader, fileDataValidatorUtil, fileManagerUtil, mapUtil, dataReader, shipGenerator,
                shipPlacer);
    }
}
