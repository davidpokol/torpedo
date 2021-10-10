package sevice;

import model.MapVO;
import sevice.exeption.MapShowExeption;
import ui.MapDisplayer;

import java.util.Arrays;

public class GameManager {


    int [][] maparray;
    MapInitializer map = new MapInitializer();
    MapDisplayer displayer = new MapDisplayer();
    ShipPlacer shipplacer = new ShipPlacer();
    DataHandler datain = new DataHandler();

    public void startGame() throws MapShowExeption {
        String name = datain.readInString();
        int mapsize = datain.readInInt();
        int numberofships = datain.readInInt();
        MapVO data = new MapVO(mapsize,map.getMap(mapsize),shipplacer.placeShips(mapsize,numberofships));

        while (isContinue(data.getReservedFields())){
            displayer.showMap(data.getMap());
            String option = formatOption(datain.readInString());

        }


    }


    private boolean isContinue(boolean[][] reserverfields){

        //TODO optimize!!!
        boolean result = false;
        for (int i = 0; i < reserverfields.length; i++) {
            for (int j = 0; j < reserverfields.length; j++) {

                if(reserverfields[i][j]){
                    result=true;
                }
            }
        }
        return result;
    }
    private String formatOption(String rawoption){

        char row = rawoption.charAt(0);
        return String.valueOf(row-65)+rawoption.charAt(1);

    }
}

