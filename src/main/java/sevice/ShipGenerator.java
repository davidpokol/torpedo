package sevice;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sevice.input.DataReader;

public class ShipGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(DataReader.class);
    private final Random random = new Random();

    public int[][] getShip(int length) {

        int[] startCoordinates = new int[2];
        int[] endCoordinates = new int[2];

        int row = random.nextInt(length);
        int row2 = row;
        int column = random.nextInt(length);
        int column2 = column;
        int direction = getShipDirection();
        if (direction == 0) {
            row2 = addLength(row, length - 1);
        } else if (direction == 1) {
            column2 = addLength(column, length - 1);
        }
        int overBound;
        if (row2 >= length) {
            overBound = row2 - (length - 1);
            row = row - overBound;
            row2 = row2 - overBound;
        } else if (column2 >= length) {
            overBound = column2 - (length - 1);
            column = column - overBound;
            column2 = column2 - overBound;
        }

        startCoordinates[0] = row;
        startCoordinates[1] = column;

        endCoordinates[0] = row2;
        endCoordinates[1] = column2;

        LOG.info(length + ". SHIP START COORDINATE: [" + startCoordinates[0] + "," + startCoordinates[1] + "]");
        LOG.info(length + ". SHIP END COORDINATE: [" + endCoordinates[0] + "," + endCoordinates[1] + "]");

        System.out.println();

        return new int[][]{
              {startCoordinates[0], startCoordinates[1]},
              {endCoordinates[0], startCoordinates[1]}
        };
    }

    private int getShipDirection() {

        return random.nextInt(2);
    }

    private int addLength(int length, int plusLength) {

        return length + plusLength;
    }

    private int[] placeFirstShip(int max) {
        int[] result = new int[2];
        result[0] = random.nextInt(max);
        result[1] = random.nextInt(max);
        LOG.info("1. SHIP COORDINATE: [" + result[0] + "," + result[1] + "]\n");
        return result;
    }
}
