package io.jreportsql.connections;

import io.jreportsql.conf.PostgresDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class ConnectionService {
    private final PostgresDataSourceFactory postgresDataSourceFactory;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public ConnectionService(@Autowired final PostgresDataSourceFactory postgresDataSourceFactory) {
        this.postgresDataSourceFactory = postgresDataSourceFactory;
    }

    public String getStr() {
        logger.info("getting cheese");
        return "cheese;;";
    }

    public boolean isValid(ConnectionDTO connectionDTO) {
        DataSource dataSource = postgresDataSourceFactory.create(connectionDTO);
        try {
            dataSource.getConnection().isValid(5);
        } catch (final SQLException e) {
            return false;
        }
        return true;
    }

    public void persist(ConnectionDTO connectionDTO) {

    }
}
