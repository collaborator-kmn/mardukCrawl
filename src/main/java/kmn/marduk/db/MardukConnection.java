package kmn.marduk.db;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Optional;
import java.util.Properties;

public class MardukConnection implements Connector<Connection> {

    private Properties mardukProperties;
    private InputStream inputStream;

    public MardukConnection(Properties properties) {
        this.mardukProperties = properties;
    }

    public MardukConnection() {
        this.inputStream = getClass().getClassLoader().getResourceAsStream("marduk.properties");
    }

    private Optional<Properties> defaultProperties() {
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            this.mardukProperties = properties;
            return Optional.of(mardukProperties);
        } catch (Exception e) {
            System.out.println("Error read file marduk.prop. " + e);
            return Optional.empty();
        }
    }

    @Override
    public Connection connect() throws ConnectorException {
        if (defaultProperties().isPresent()) {
            OracleHandle oracleHandle = new OracleHandle();
            oracleHandle.setServer(mardukProperties.getProperty("server"));
            oracleHandle.setPassword(mardukProperties.getProperty("password").toCharArray());
            oracleHandle.setDatabase(mardukProperties.getProperty("database"));
            oracleHandle.setPort(Integer.parseInt(mardukProperties.getProperty("port")));

            return new JDBCConnector(oracleHandle).connect();
        } else return null;
    }
}