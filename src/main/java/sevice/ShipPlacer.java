package sevice;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ShipPlacer {

        Random r = new Random();
        public boolean[][] placeShips(int mapsize,int numberofships) {

            List<String> rawcoordinates = generateRawCoordinates(mapsize,numberofships);
            int[][] coordinates = splitRawCoordinates(rawcoordinates,numberofships);
            return coordinateConverter(coordinates,mapsize);

            //TODO meg lehessen adni a hajók számát

        }
        private List<String> generateRawCoordinates(int mapsize,int numberofships){

            Random r = new Random();

            HashSet<String> result = new HashSet<>();
            StringBuilder rawcoordinate = new StringBuilder();
            while(result.size()!=numberofships){

                int a = r.nextInt(mapsize);
                int b = r.nextInt(mapsize);

                result.add(putTogether(a,b));
            }
            return new ArrayList<>(result);
        }
        private int[][] splitRawCoordinates(List<String> rawdata,int numberofships){

            String row,column;
            int[][] coordinates = new int[rawdata.size()][2];

            for (int i = 0; i < numberofships; i++) {

                row = rawdata.get(i).substring(0,1);
                column = rawdata.get(i).substring(1,2);

                coordinates[i][0]=Integer.parseInt(row);
                coordinates[i][1]=Integer.parseInt(column);
            }
            return coordinates;
        }

        private boolean[][] coordinateConverter(int[][]coordinates,int mapsize){

            boolean[][] properdata = new boolean[mapsize][mapsize];

            for (int i = 0; i < mapsize; i++) {
                for (int j = 0; j < mapsize; j++) {
                    properdata[i][j]=false;
                }
            }
            for (int i = 0; i < coordinates.length; i++) {
                properdata[coordinates[i][0]][coordinates[i][1]] = true;
            }
            return properdata;
        }
        private String putTogether(int a, int b){
            return String.valueOf(a).concat(String.valueOf(b));
        }
}
