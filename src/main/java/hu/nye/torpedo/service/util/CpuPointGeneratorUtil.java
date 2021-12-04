package hu.nye.torpedo.service.util;

import java.util.Random;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;

public class CpuPointGeneratorUtil {

    private final GameState gameState;

    /**
     * Class constructor.
     */
    public CpuPointGeneratorUtil(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * This method generates a random point, which fits to the map.
     */
    public int[] generate() {

        Random random = new Random();
        MapVO mapVo = gameState.getCurrentCpuMap();

        int size = mapVo.getMapSize();
        int[] tip = new int[2];
        do {

            tip[0] = random.nextInt(size);
            tip[1] = random.nextInt(size);

        } while (!"0".equals(mapVo.getMap()[tip[0]][tip[1]]));
        return tip;

    }
}
