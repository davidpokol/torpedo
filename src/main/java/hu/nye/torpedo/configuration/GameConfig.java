package hu.nye.torpedo.configuration;

import java.io.IOException;
import java.util.List;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.service.command.InputHandler;
import hu.nye.torpedo.service.exeption.FileDataException;
import hu.nye.torpedo.service.exeption.FileReadException;
import hu.nye.torpedo.service.game.GameCycle;
import hu.nye.torpedo.service.game.GameStepPerformer;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.input.MapReader;
import hu.nye.torpedo.service.ship.ShipGenerator;
import hu.nye.torpedo.service.ship.ShipPlacer;
import hu.nye.torpedo.service.util.FileDataValidatorUtil;
import hu.nye.torpedo.service.util.FileManagerUtil;
import hu.nye.torpedo.service.util.MapUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Configuration
public class GameConfig {

    @Bean
    public GameStepPerformer gameStepPerformer(DataReader dataReader, InputHandler inputHandler) {
        return new GameStepPerformer(dataReader, inputHandler);
    }

    @Bean
    public GameCycle gameCycle(GameState gameState) {
        return new GameCycle(gameState);
    }


    @Bean
    public GameState gameState(MapReader mapReader, FileDataValidatorUtil fileDataValidatorUtil,
                               FileManagerUtil fileManagerUtil, MapUtil mapInitUtil, DataReader dataReader,
                               ShipGenerator shipGenerator, ShipPlacer shipPlacer) throws FileReadException {

        List<String> lines = null;

        try {
            lines = mapReader.getLinesFromFile();
            fileDataValidatorUtil.isValidMap(lines);

        } catch  (FileReadException | IOException | FileDataException e) {
            e.printStackTrace();
        }

        boolean[][] cpuShipMap = fileManagerUtil.getPreparedMap(lines);
        String[][] cpuUiMap = mapInitUtil.getMap(lines.size());
        MapVO cpuMapVO = new MapVO(cpuUiMap, cpuShipMap);

        System.out.print("Please enter your name: ");
        String name = dataReader.readInput();

        boolean[][] userShipMap = mapInitUtil.getShipMap(lines.size());
        for (int i = 1; i < 5; i++) {

            int[][] shipCoordinates = shipGenerator.getShip(i, lines.size());
            userShipMap = shipPlacer.place(shipCoordinates, userShipMap);
        }

        String[][] uiMap = mapInitUtil.getMap(lines.size());
        UserMapVO userMapVO = new UserMapVO(uiMap, userShipMap, name);

        return new GameState(cpuMapVO, userMapVO, false);
    }

}
