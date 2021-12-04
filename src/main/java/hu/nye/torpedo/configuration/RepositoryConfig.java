package hu.nye.torpedo.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.torpedo.persistance.JdbcGameManager;
import hu.nye.torpedo.persistance.JdbcGameSavesRepository;
import hu.nye.torpedo.service.util.MapToStringUtil;
import hu.nye.torpedo.service.util.MapUnwrapperUtil;
import hu.nye.torpedo.service.util.MapUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";

    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Bean
    public JdbcGameSavesRepository jdbcGameSavesRepository(Connection connection, JdbcGameManager jdbcGameManager,
                                                           MapUtil mapUtil, MapToStringUtil mapConverterUtil,
                                                           MapUnwrapperUtil mapUnwrapperUtil) {
        return new JdbcGameSavesRepository(connection, jdbcGameManager, mapUnwrapperUtil);
    }

    @Bean
    JdbcGameManager jdbcGameManager(Connection connection, MapToStringUtil mapToStringUtil) {
        return new JdbcGameManager(connection, mapToStringUtil);
    }
}
