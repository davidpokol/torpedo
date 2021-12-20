package hu.nye.torpedo.service.ship;

/**
 * Places a ship in a map.
 */
public class ShipPlacer {

    /** This method places a ship in a map.
     *
     * @param coordinates which defines start and end points of a ship.
     */
    public boolean[][] place(int[][] coordinates, boolean[][] map) {

        boolean[][] result;
            if (coordinates[0][1] == coordinates[1][1]) {
                result = placeVertical(coordinates, map);
            } else {
                result = placeHorizontal(coordinates, map);
            }
        return result;
    }

    private boolean[][] placeVertical(int[][] coordinates, boolean[][] map) {

        for (int i = coordinates[0][0]; i <= coordinates[1][0]; i++) {
            map[i][coordinates[0][1]] = true;
        }
        return map;
    }

    private boolean[][] placeHorizontal(int[][] coordinates, boolean[][] map) {

        for (int i = coordinates[0][1]; i <= coordinates[1][1]; i++) {
            map[coordinates[0][0]][i] = true;
        }
        return map;
    }
}
