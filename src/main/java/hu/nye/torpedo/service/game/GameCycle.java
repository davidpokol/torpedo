package hu.nye.torpedo.service.game;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import hu.nye.torpedo.ui.WinnerText;

/**
 * Checks if is there any ships left.
 */
public class GameCycle {

    private final GameState gameState;
    private final XmlHighScoreRepository xmlHighScoreRepository;
    private final WinnerText winnerText;

    public GameCycle(GameState gameState, XmlHighScoreRepository xmlHighScoreRepository, WinnerText winnerText) {
        this.gameState = gameState;
        this.xmlHighScoreRepository = xmlHighScoreRepository;
        this.winnerText = winnerText;
    }

    /**
     * Returns true if there is no more ships left on neither maps, otherwise it is false.
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
        updateHighScore(cpuShipCount, userShipCount);
        return !(cpuShipCount == 0 || userShipCount == 0);
    }

    /**
     * This method calls the xmlHighScoreRepository class, in order to update the high-score.
     **/
    private void updateHighScore(int cpuShips, int userShips) {
        if (userShips == 0) {
            winnerText.player();
            xmlHighScoreRepository.update(gameState.getCurrentUserMap().getUserName());

        } else if (cpuShips == 0) {
            winnerText.cpu();
            xmlHighScoreRepository.update("The CPU");
        }
    }
}
