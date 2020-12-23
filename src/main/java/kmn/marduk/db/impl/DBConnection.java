package kmn.marduk.db.impl;

import java.sql.Connection;
import java.util.Properties;

public class DBConnection {
    private final JDBCConnector jdbcConnector;

    public DBConnection(Properties properties) {
        jdbcConnector = new JDBCConnector(new SQLServerHandle(properties));
    }

    public Connection getConnection() throws ConnectorException {
        return jdbcConnector.connect();
    }
}
