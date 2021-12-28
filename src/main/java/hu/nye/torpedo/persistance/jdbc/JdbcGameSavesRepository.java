package hu.nye.torpedo.persistance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.service.util.MapUnWrapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helps in saving/loading the game state to/from the database.
 */
public class JdbcGameSavesRepository implements AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcGameSavesRepository.class);
    private static final String SELECT_STATEMENT = "SELECT * FROM game_saves WHERE ID = ?;";
    private final Connection connection;
    private final JdbcGameManager jdbcGameManager;
    private final MapUnWrapperUtil mapUnwrapperUtil;

    /**
     * Class constructor.
     */
    public JdbcGameSavesRepository(Connection connection, JdbcGameManager jdbcGameManager,
                                   MapUnWrapperUtil mapUnwrapperUtil) {
        this.connection = connection;
        this.jdbcGameManager = jdbcGameManager;

        this.mapUnwrapperUtil =  mapUnwrapperUtil;
    }

    /**
     * Saves the game state to the database.
     */
    public void save(GameState gameState, String saveId) {

        String preId = gameState.getCurrentUserMap().getUserName();
        try {
            jdbcGameManager.deleteCurrentlyStoredSave(preId + saveId);
            jdbcGameManager.insertNewSave(gameState, preId + saveId);
        } catch (SQLException e) {
            LOGGER.error("Unexpected exception during saving game state", e);
        }
    }

    /**
     * Loads a game state from the database.
     */
    public GameState load(String option) {

        String userName = null;
        String[][] userMap = new String[0][];
        boolean[][] userShipMap = new boolean[0][];

        String[][] cpuMap = new String[0][];
        boolean[][] cpuShipMap = new boolean[0][];

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT)) {
            preparedStatement.setString(1, option);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                userName = resultSet.getString("userName");
                userMap = mapUnwrapperUtil.convertStringToMap(resultSet.getString("UserMap"));
                userShipMap = mapUnwrapperUtil.convertStringToShipMap(resultSet.getString("userShipMap"));
                cpuMap = mapUnwrapperUtil.convertStringToMap(resultSet.getString("cpuMap"));
                cpuShipMap = mapUnwrapperUtil.convertStringToShipMap(resultSet.getString("CpuShipMap"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        MapVO mapVO = new MapVO(cpuMap, cpuShipMap);
        UserMapVO userMapVO = new UserMapVO(userMap, userShipMap, userName);
        return new GameState(mapVO, userMapVO, false);
    }

    /** Closes the connection with the database.
     *
     * @throws SQLException when error occurs while closing the connection.
     */
    public void close() throws SQLException {
        connection.close();
    }

}