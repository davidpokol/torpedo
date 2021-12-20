package hu.nye.torpedo.model;

import java.util.Arrays;

/**
 * Stores the CPU'S data in the live game.
 */
public class MapVO {

    private final String [][] map;
    private final boolean[][] shipMap;

    public MapVO(String[][] map, boolean[][] reservedPoints) {
        this.map = map;
        this.shipMap = reservedPoints;
    }

    public int getMapSize() {
        return map.length;
    }

    public String[][] getMap() {
        return deepCopy(map);
    }

    public boolean[][] getShipMap() {
        return deepCopy(shipMap);
    }

    private String[][] deepCopy(String[][] array) {

        String[][] copy = new String[array.length][];

        for (int i = 0; i < array.length; i++) {
            copy[i] = new String[array[i].length];
            for (int j = 0; j < array.length; j++) {
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }

    private boolean[][] deepCopy(boolean[][] array) {

        boolean [][] copy = new boolean[array.length][];
        for (int i = 0; i < array.length; i++) {
            copy[i] = new boolean[array[i].length];
            for (int j = 0; j < array.length; j++) {
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapVO mapVO = (MapVO) o;
        return Arrays.deepEquals(map, mapVO.map) && Arrays.deepEquals(shipMap, mapVO.shipMap);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(map);
        result = 31 * result + Arrays.deepHashCode(shipMap);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "map=" + Arrays.toString(map) +
                ", shipMap=" + Arrays.toString(shipMap) +
                '}';
    }
}


