package hu.nye.torpedo.service.game;

import hu.nye.torpedo.model.GameState;

/**
 * Checks if is there any ships left.
 */
public class GameCycle {

    private final GameState gameState;

    public GameCycle(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * @return true if there is no more ships left on neither maps, otherwise it is false.
     */
    public boolean isInGame() {

        int size = gameState.getCurrentCpuMap().getMapSize();
        boolean[][] cpu = gameState.getCurrentCpuMap().getShipMap();
        boolean[][] user = gameState.getCurrentUserMap().getShipMap();
        int cpuShipCount = 0;
        int userShipCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (cpu[i][j]) {
                    cpuShipCount++;
                }
                if (user[i][j]) {
                    userShipCount++;
                }
            }
        }
        winnerText(cpuShipCount, userShipCount);
        return !(cpuShipCount == 0 || userShipCount == 0);
    }

    /**
     *This method writes out the winner, if the game ended.
     **/
    private void winnerText(int cpuShips, int userShips) {

        if (userShips == 0) {
            System.out.println("You won! :)");
        } else if (cpuShips == 0) {
            System.out.println("The CPU won! :(");
        }
    }
}
