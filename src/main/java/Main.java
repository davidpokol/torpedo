import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import sevice.MapInitializer;
import sevice.ShipGenerator;
import sevice.exeption.MapReadException;
import sevice.exeption.OptionReadException;
import sevice.input.DataReader;

public class Main {

    public static void main(String[] args) throws MapReadException, OptionReadException {

        BufferedInputStream is = new BufferedInputStream(System.in);
        DataReader reader = new DataReader(new BufferedReader(new InputStreamReader(is)));

        MapInitializer initializer = new MapInitializer();
        ShipGenerator ship = new ShipGenerator();

        System.out.print("Please enter the size of the map: ");
        int size = Integer.parseInt(reader.readInput());

        for (int i = 1; i < size; i++) {
            int[][] currentShip = ship.getShip(i);

        }

        int[][] map = initializer.getMap(size);

    }

}
