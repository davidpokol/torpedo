package hu.nye.torpedo.service.util;

import java.io.IOException;
import java.util.List;

import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.service.exeption.FileDataException;
import hu.nye.torpedo.service.exeption.FileReadException;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.input.MapReader;
import hu.nye.torpedo.service.ship.ShipGenerator;
import hu.nye.torpedo.service.ship.ShipPlacer;

/**
 * This class helps initialize mapVO and UserMapVO.
 */
public class MapVoInitUtil {

    MapReader mapReader;
    FileDataValidatorUtil fileDataValidatorUtil;
    FileManagerUtil fileManagerUtil;
    MapUtil mapUtil;
    DataReader dataReader;
    ShipGenerator shipGenerator;
    ShipPlacer shipPlacer;

    public MapVoInitUtil(MapReader mapReader, FileDataValidatorUtil fileDataValidatorUtil, FileManagerUtil
            fileManagerUtil, MapUtil mapUtil, DataReader dataReader, ShipGenerator shipGenerator,
                         ShipPlacer shipPlacer) {
        this.mapReader = mapReader;
        this.fileDataValidatorUtil = fileDataValidatorUtil;
        this.fileManagerUtil = fileManagerUtil;
        this.mapUtil = mapUtil;
        this.dataReader = dataReader;
        this.shipGenerator = shipGenerator;
        this.shipPlacer = shipPlacer;
    }

    /**
     * Initializes MapVO.
     */
    public MapVO mapVoInit() {
        List<String> lines;
        boolean[][] cpuShipMap = new boolean[0][];
        String[][] cpuUiMap = new String[0][];

        try {
            lines = mapReader.getLinesFromFile();
            fileDataValidatorUtil.isValidMap(lines);
            cpuShipMap = fileManagerUtil.getPreparedMap(lines);
            cpuUiMap = mapUtil.getMap(lines.size());

        } catch  (FileReadException | IOException | FileDataException e) {
            e.printStackTrace();
        }

        return new MapVO(cpuUiMap, cpuShipMap);
    }

    /**
     * Initializes UserMapVO.
     */
    public UserMapVO userMapVoInit(int size) {

        System.out.print("Please enter your name: ");
        String name = dataReader.readInput();

        boolean[][] userShipMap = mapUtil.getShipMap(size);
        for (int i = 1; i < 5; i++) {

            int[][] shipCoordinates = shipGenerator.getShip(i, size);
            userShipMap = shipPlacer.place(shipCoordinates, userShipMap);
        }
        String[][] uiMap = mapUtil.getMap(size);

        return new UserMapVO(uiMap, userShipMap, name);
    }
}
