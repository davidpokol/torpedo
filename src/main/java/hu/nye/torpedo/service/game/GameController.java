package hu.nye.torpedo.service.game;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Starts the game loop, and checks game progress.
 */
public class GameController {

    private static final Logger LOG = LoggerFactory.getLogger(GameController.class);
    private final GameState gameState;
    private final GameStepPerformer gameStepPerformer;

    public GameController(GameState gameState, GameStepPerformer gameStepPerformer) {
        this.gameState = gameState;
        this.gameStepPerformer = gameStepPerformer;
    }

    /**
     * Starts the game loop.
     */
    public void start() {
        LOG.info("username = '{}'", gameState.getCurrentUserMap().getUserName());
        LOG.info("Starting game loop");

        while (isGameInProgress()) {
            gameStepPerformer.performGameStep();
        }
        LOG.info("Game loop finished");


        LOG.info("Highscore table updated!");
    }

    private boolean isGameInProgress() {
        return !gameState.isShouldExit();
    }
}
