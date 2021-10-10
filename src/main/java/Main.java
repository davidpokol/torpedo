import sevice.DataHandler;
import sevice.ShipPlacer;
import sevice.exeption.MapReadExeption;
import sevice.exeption.MapShowExeption;
import ui.MapDisplayer;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws MapReadExeption, MapShowExeption {

        DataHandler datain = new DataHandler();
        ShipPlacer ships = new ShipPlacer();
        MapDisplayer display = new MapDisplayer();

        boolean[][] reservedpoints = ships.placeShips(5,5);



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }


    }






}
