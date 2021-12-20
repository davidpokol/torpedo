package hu.nye.torpedo.configuration;

import java.util.List;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.model.player.Player;
import hu.nye.torpedo.model.player.Players;
import hu.nye.torpedo.service.exeption.FileReadException;
import hu.nye.torpedo.service.util.MapVoInitUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for MODEL classes.
 */
@Configuration
public class ModelConfig {

    @Bean
    Player player() {
        return new Player();
    }

    @Bean
    Players playerVO(List<Player> players) {
        return new Players(players);
    }

    /**
     * Configuration method for gameState class.
     */
    @Bean
    public GameState gameState(MapVoInitUtil mapVoInitUtil) throws FileReadException {

        MapVO cpuMapVo = mapVoInitUtil.mapVoInit();
        UserMapVO userMapVo = mapVoInitUtil.userMapVoInit(cpuMapVo.getMapSize());
        return new GameState(cpuMapVo, userMapVo, false);
    }
}
