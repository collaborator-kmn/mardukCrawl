package kmn.marduk.db;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Optional;
import java.util.Properties;

public class MardukConnection implements Connector<Connection> {

    private  Properties mardukProperties;

    public MardukConnection(Properties properties) {
        this.mardukProperties = properties;
    }

    private static Optional<Properties> defaultProperties(InputStream inputStream) {
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            return Optional.of(properties);
        } catch (Exception e) {
            System.out.println("Error read file marduk.prop. " + e);
            return Optional.empty();
        }
    }

    private static Optional<MardukConnection> defaultConnection(InputStream inputStream) {
        Optional<Properties> perhaps = defaultProperties(inputStream);
        return perhaps.map(MardukConnection::new);
    }

    @Override
    public Connection connect() throws ConnectorException {
        OracleHandle oracleHandle = new OracleHandle();
        oracleHandle.setServer(mardukProperties.getProperty("server"));
        oracleHandle.setPassword(mardukProperties.getProperty("password").toCharArray());
        oracleHandle.setDatabase(mardukProperties.getProperty("database"));
        oracleHandle.setPort(Integer.parseInt(mardukProperties.getProperty("port")));

        return new JDBCConnector(oracleHandle).connect();
    }
}