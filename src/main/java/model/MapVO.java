package model;

import java.util.Arrays;
import java.util.Objects;

public final class MapVO {

    private final int mapSize;
    private final int [][] map;
    private final boolean[][] reservedFields;


    public MapVO(int mapsize, int[][] map, boolean[][] reservedPoints) {
        this.mapSize = mapsize;
        this.map = map;
        this.reservedFields = reservedPoints;
    }

    public int getMapSize() {
        return mapSize;
    }

    public int[][] getMap() {
        return deepCopy(map);
    }

    public boolean[][] getReservedFields() {
        return deepCopy(reservedFields);
    }

    private int[][] deepCopy(int[][] array) {

        int[][] copy = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            copy[i] = new int[array[i].length];
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
        return mapSize == mapVO.mapSize && Arrays.deepEquals(map, mapVO.map)
                && Arrays.deepEquals(reservedFields, mapVO.reservedFields);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mapSize);
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + Arrays.deepHashCode(reservedFields);
        return result;
    }
}


