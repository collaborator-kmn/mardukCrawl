package kmn.marduk.db;

import java.sql.Connection;
import java.util.Properties;

public class MardukConnection implements Connector<Connection> {

    private Properties mardukProperties;

    @Override
    public Connection connect() throws ConnectorException {
        OracleHandle oracleHandle  = new OracleHandle();
        oracleHandle.setServer(mardukProperties.getProperty("server"));
        oracleHandle.setPassword(mardukProperties.getProperty("password").toCharArray());
        oracleHandle.setDatabase(mardukProperties.getProperty("database"));
        oracleHandle.setPort(Integer.parseInt(mardukProperties.getProperty("port")));
        return new JDBCConnector(oracleHandle).connect();
    }
}
