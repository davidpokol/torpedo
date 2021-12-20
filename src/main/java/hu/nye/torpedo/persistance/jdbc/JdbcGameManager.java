package hu.nye.torpedo.persistance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.service.util.MapToStringUtil;

/**
 * Helps in database managing.
 */
public class JdbcGameManager {

    private final Connection connection;
    private final MapToStringUtil mapToStringUtil;

    public JdbcGameManager(Connection connection, MapToStringUtil mapToStringUtil) {
        this.connection = connection;
        this.mapToStringUtil = mapToStringUtil;
    }

    private static final String INSERT_STATEMENT = "INSERT INTO game_saves " +
            "(id, userName, userMap, userShipMap, cpuMap, CpuShipMap, Date) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_STATEMENT = "DELETE FROM game_saves WHERE id = ?;";
    private static final String SELECT_USER_SAVES_STATEMENT = "SELECT ID, Date FROM game_saves WHERE userName = ?;";

    /**
     * Shows all saved games, of the user.
     */
    public List<String> showGameSavesOfUser(String userName) {

        List<String> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SAVES_STATEMENT)) {
            preparedStatement.setString(1, userName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(resultSet.getString("ID") + " " + resultSet.getString("Date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /** Deletes a game state save, at an ID.
     *
     * To override a save, the previous save must be deleted.
     *
     * @throws SQLException if an error occurs while deleting a game state.
     */
    public void deleteCurrentlyStoredSave(String deleteId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT)) {
            preparedStatement.setString(1, deleteId);
            preparedStatement.executeUpdate();
        }
    }

    /** Inserts new save at an ID.
     *
     * @throws SQLException if an error occurs while saving a game state.
     */
    public void insertNewSave(GameState gameState, String saveId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)) {
            preparedStatement.setString(1, saveId);
            preparedStatement.setString(2, gameState.getCurrentUserMap().getUserName());
            preparedStatement.setString(3, mapToStringUtil.convertMapToString(gameState
                    .getCurrentUserMap().getMap()));
            preparedStatement.setString(4, mapToStringUtil.convertShipMapToString(gameState
                    .getCurrentUserMap().getShipMap()));
            preparedStatement.setString(5, mapToStringUtil.convertMapToString(gameState
                    .getCurrentCpuMap().getMap()));
            preparedStatement.setString(6, mapToStringUtil.convertShipMapToString(gameState
                    .getCurrentCpuMap().getShipMap()));
            preparedStatement.setString(7, dateNow());

            preparedStatement.executeUpdate();
        }
    }

    private String dateNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        return formatter.format(new Date(System.currentTimeMillis()));
    }
}
