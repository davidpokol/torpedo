package sevice;

import sevice.exeption.MapReadException;

public class MapInitializer {

    public int[][] getMap(int mapSize) throws MapReadException {

        int[][] basemap = new int[mapSize][mapSize];
        if (isContinue(mapSize)) {

            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    basemap[i][j] = 0;
                }
            }
        } else {
            throw new MapReadException("Map size must be an Integer value ");
        }
        return basemap;
    }

    private boolean isContinue(int mapsize) {
        return mapsize < 10;
    }
}
