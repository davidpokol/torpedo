package sevice;

public class MapInitializer {

    public int[][] getMap(int mapsize){

        int[][] basemap = new int[mapsize][mapsize];

        for (int i = 0; i < mapsize; i++) {
            for (int j = 0; j < mapsize; j++) {
                basemap[i][j]=0;
            }
        }
        return basemap;
    }
}
