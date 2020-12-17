package kmn.marduk.common;

import kmn.marduk.db.*;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.ReaderUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class MardukOracleFactory implements MardukSQLFactory {
    private final JDBCConnector jdbcConnector;

    public MardukOracleFactory(Properties properties){
         jdbcConnector = new JDBCConnector(new OracleHandle(properties));
    }

    @Override
    public Connection getConnection() throws ConnectorException {
        return jdbcConnector.connect();
    }

    @Override
    public Mapper<Marduk, SQLException> getMapper() {
        return new MardukMapper();
    }

    public static MardukSQLFactory newInstance(){
        return new MardukOracleFactory(ReaderUtils.readMardukResources());
    }

}
