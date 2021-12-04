package hu.nye.torpedo.service.ship;

/**
 * Checks if a map validate.
 */
public class MapChecker {

    /**
     *Checks if a ship is placeable to the user's map.
     */
    public boolean check(int[][] coordinates, boolean[][] map) {

        boolean result = true;

        int x1 = coordinates[0][0] > 0 ? coordinates[0][0] - 1 : coordinates[0][0];
        int x2 = coordinates[1][0] < map.length - 1 ? coordinates[1][0] + 1 : coordinates[1][0];

        int y1 = coordinates[0][1] > 0  ? coordinates[0][1] - 1 : coordinates[0][1];
        int y2 = coordinates[1][1] < map.length - 1 ? coordinates[1][1] + 1 : coordinates[1][1];

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {

                if (map[i][j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;

    }
}
