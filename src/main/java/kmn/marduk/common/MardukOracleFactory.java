package kmn.marduk.common;

import kmn.marduk.db.*;
import kmn.marduk.entity.Marduk;
import kmn.marduk.utils.ReaderUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class MardukOracleFactory implements MardukFactory{

    private Connector<Connection> connector;

    public MardukOracleFactory(Connector<Connection> connector){
        this.connector = connector;
    }

    @Override
    public Connector<Connection> getConnection() {
        return connector;
    }

    @Override
    public Mapper<Marduk, SQLException> getMapper() {
        return new MardukMapper();
    }

    public static MardukFactory newInstance() {
        Properties properties = ReaderUtils.readMardukResources();
        return new MardukOracleFactory(new JDBCConnector(new OracleHandle(properties)));
    }

}
