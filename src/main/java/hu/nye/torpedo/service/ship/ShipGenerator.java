package hu.nye.torpedo.service.ship;

import java.util.Random;

import hu.nye.torpedo.service.input.DataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generates a ship.
 */
public class ShipGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(DataReader.class);
    private final Random random = new Random();

    /**
     * This method generates a ship depends on the size of a map.
     *
     * @param length is the length of the generated ship.
     */
    public int[][] getShip(int length, int mapsize) {

        int[][] coordiantes = new int[2][2];

        if (length == 1) {
            coordiantes = generateFirstShip(mapsize);

        } else {

            int row = random.nextInt(mapsize - 1);
            int row2 = row;
            int column = random.nextInt(mapsize - 1);
            int column2 = column;
            int direction = getShipDirection();
            if (direction == 0) {
                row2 = addLength(row, length - 1);
            } else if (direction == 1) {
                column2 = addLength(column, length - 1);
            }
            int overBound;
            if (row2 >= length) {
                overBound = row2 - (length > 3 ? 3 : length - 1);
                row = row - overBound;
                row2 = row2 - overBound;
            } else if (column2 >= length) {
                overBound = column2 - (length > 3 ? 3 : length - 1);
                column = column - overBound;
                column2 = column2 - overBound;
            }

        coordiantes[0][0] = row;
        coordiantes[0][1] = column;
        coordiantes[1][0] = row2;
        coordiantes[1][1] = column2;
        }
        return coordiantes;
    }

    private int getShipDirection() {

        return random.nextInt(2);
    }

    private int addLength(int length, int plusLength) {

        return Math.min(length + plusLength, 3);
    }

    private int[][] generateFirstShip(int max) {
        int[][] result = new int[2][2];
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        result[0][0] = a;
        result[0][1] = b;

        result[1][0] = a;
        result[1][1] = b;
        return result;
    }
}
