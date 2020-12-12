package kmn.marduk.common;

import kmn.marduk.db.*;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.SQLException;


public class MardukOracleFactory implements MardukFactory{

    private JDBCConnector jdbcConnector;

    public MardukOracleFactory(){
        jdbcConnector.setHandle(new OracleHandle());
    }

    @Override
    public Connector<Connection> getConnection() throws ConnectorException {
        jdbcConnector.connect();
        return jdbcConnector;

    }

    @Override
    public Mapper<Marduk, SQLException> getMapper() {
        return new MardukMapper();
    }
}
