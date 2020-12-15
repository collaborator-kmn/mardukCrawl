package kmn.marduk.common;

import kmn.marduk.db.*;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.ReaderUtils;

import java.sql.Connection;
import java.sql.SQLException;


public class MardukOracleFactory implements MardukSQLFactory {
    private final JDBCConnector jdbcConnector;

    public MardukOracleFactory(ReaderUtils readerUtils){
         jdbcConnector = new JDBCConnector(new OracleHandle(readerUtils.readMardukResources()));
    }

    @Override
//    Connector поменять на Connection
    public Connection getConnection() throws ConnectorException {
        return jdbcConnector.connect();
    }

    @Override
    public Mapper<Marduk, SQLException> getMapper() {
        return new MardukMapper();
    }

}
