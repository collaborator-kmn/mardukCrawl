package kmn.marduk.common;

import kmn.marduk.db.Connector;
import kmn.marduk.db.ConnectorException;
import kmn.marduk.db.OracleHandle;

import java.sql.Connection;


public class MardukOracleFactory implements MardukFactory{

    private final Connector<OracleHandle> connector;

    public MardukOracleFactory(Connector <OracleHandle> connector) {
        this.connector = connector;
    }

    @Override
    public Connector getConnection(){
        return connector;
    }

    @Override
    public Mapper getMapper() {
        return new MardukMapper();
    }
}
