package hu.nye.torpedo.ui;

import hu.nye.torpedo.model.GameState;

/**
 * This class displays a game state.
 */
public class MapDisplayer {

    GameState gameState;

    /**
     * Class constructor.
     */
    public MapDisplayer(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * This method writes out the current game state to the console.
     */
    public void showGameState() {


        System.out.println("USER'S MAP");
        showMap(gameState.getCurrentUserMap().getMap());
        System.out.println();
        System.out.println("CPU'S MAP");
        showMap(gameState.getCurrentCpuMap().getMap());
    }

    private void showMap(String[][] map) {
        writeOutHeader(gameState.getCurrentCpuMap().getMapSize());
        for (int i = 0; i < map.length; i++) {
            System.out.print((char) (65 +  i) + "|");
            for (int j = 0; j < map.length; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }
    }

    private void writeOutHeader(int length) {
        System.out.print("  ");
        for (int i = 1; i <= length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
