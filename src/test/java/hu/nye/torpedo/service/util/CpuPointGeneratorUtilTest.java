package hu.nye.torpedo.service.util;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CpuPointGeneratorUtilTest {

    private CpuPointGeneratorUtil underTest;
    private final GameState gameState = new GameState(null, null, false);

    @Test
    public void testGenerateShouldReturnWithARandomFreePointInTheMap() {

        //Given
        int[] result;
        final String[][] map = {{"0","1"},{"0","1"}};
        gameState.setCurrentCpuMap(new MapVO(map, null));
        underTest = new CpuPointGeneratorUtil(gameState);

        //When
        result = underTest.generate();

        //Then
        Assertions.assertEquals("0", map[result[0]][result[1]]);
    }
}
