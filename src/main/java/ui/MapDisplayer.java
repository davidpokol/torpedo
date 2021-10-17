package ui;

public class MapDisplayer {

    public void showMap(int[][] map, int size)  {

        writeOutHeader(size);
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }

    }

    public void showMap(int[][] map) {

        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < map.length; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }

    }

    private void writeOutHeader(int length) {

        System.out.print("  ");
        for (int i = 65; i < 65 + length; i++) {
            System.out.print(" " + (char) i);
        }
        System.out.println();

    }
}
