package hu.nye.torpedo.persistance;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;

public interface GameSavesRepository {

    void save(GameState gameState, String saveId);

    GameState load(String option);

    void close() throws Exception;

}