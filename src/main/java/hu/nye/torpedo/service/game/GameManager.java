package hu.nye.torpedo.service.game;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;

/**
 * Managing the game progress.
 */
public class GameManager {

    private final GameState gameState;

    /**
     *Class constructor.
     */
    public GameManager(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Shoots at a point of the cpu's map.
     *
     * @param coordinates has the coordinates of the targeted point.
     * @return the user's value object that already contains the shot point
     */
    public boolean fireAtPoint(int[] coordinates) {

        UserMapVO userMapVO = gameState.getCurrentUserMap();
        boolean result = false;
        String[][] currentMap = userMapVO.getMap();
        boolean[][] shipMap = userMapVO.getShipMap();

            if (shipMap[coordinates[0]][coordinates[1]]) {
                currentMap[coordinates[0]][coordinates[1]] = "x";
                result = true;
            } else {
                currentMap[coordinates[0]][coordinates[1]] = "-";
            }
            shipMap[coordinates[0]][coordinates[1]] = false;

            gameState.setCurrentUserMap(new UserMapVO(currentMap, shipMap, userMapVO.getUserName()));

            return result;
    }

    /**
     * @param coordinates has the coordinates of the targeted point
     * @return the  cpu's value object that already contains the shot point
     */
    public boolean cpuShoot(int[] coordinates) {

        MapVO mapVO = gameState.getCurrentCpuMap();
        boolean result = false;
        String[][] currentMap = mapVO.getMap();
        boolean[][] shipMap = mapVO.getShipMap();

            if (shipMap[coordinates[0]][coordinates[1]]) {
                currentMap[coordinates[0]][coordinates[1]] = "x";
                result = true;
            } else {
                currentMap[coordinates[0]][coordinates[1]] = "-";
            }
            shipMap[coordinates[0]][coordinates[1]] = false;

        gameState.setCurrentCpuMap(new MapVO(currentMap, shipMap));
        return result;

    }
}
