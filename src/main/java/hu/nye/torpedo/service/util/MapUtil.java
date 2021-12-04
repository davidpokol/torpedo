package hu.nye.torpedo.service.util;

import java.util.ArrayList;
import java.util.List;


public class MapUtil {

    /**
     * @return two dimension String array  filled with only "0" values.
     **/
    public String[][] getMap(int mapSize) {

        String [][] basemap = new String[mapSize][mapSize];
        if (mapSize < 10) {

            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    basemap[i][j] = "0";
                }
            }
        }
        return basemap;
    }

    /**
     * @return two dimension boolean array  filled with only "0" values.
     */
    public boolean[][] getShipMap(int mapSize) {

        boolean[][] result = new boolean[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                result[i][j] = false;
            }
        }
        return result;
    }

    /**
     * @param rowIndex defines which line is going to return from the String map.
     *
     * @return returns a line of the String map.
     */
    public List<String> getRowOfMap(String[][] map, int rowIndex) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            result.add(map[rowIndex][i]);
        }

        return result;
    }

    /**
     * @param rowIndex defines which line is going to return from the boolean map.
     * @return returns a line of the boolean map.
     */
    public List<Boolean> getRowOfShipMap(boolean[][] shipMap, int rowIndex) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < shipMap.length; i++) {
            result.add(shipMap[rowIndex][i]);
        }

        return result;
    }
}
