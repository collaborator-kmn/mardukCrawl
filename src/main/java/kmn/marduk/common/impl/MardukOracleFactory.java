package kmn.marduk.common.impl;

import kmn.marduk.core.transformation.resultset2marduk.Mapper;
import kmn.marduk.common.MardukFactory;
import kmn.marduk.core.transformation.resultset2marduk.impl.MardukMapper;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.db.impl.JDBCConnector;
import kmn.marduk.db.impl.OracleHandle;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.ReaderUtils;
import kmn.marduk.utils.SettingStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/** Реализация фабрики MardukOracle
 *
 */
public class MardukOracleFactory implements MardukFactory {
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

    public static MardukFactory newInstance(){
        return new MardukOracleFactory(ReaderUtils.readPropertiesFromFile(SettingStorage.MARDUK_PROPERTIES));
    }

}
