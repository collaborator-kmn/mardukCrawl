package kmn.marduk.common;

import kmn.marduk.db.Connector;
import kmn.marduk.db.OracleHandle;


public class MardukOracleFactory implements MardukFactory{


    public MardukOracleFactory() {
    }

    @Override
    public Connector getConnection() {
        return (Connector) new OracleHandle();
    }

    @Override
    public Mapper getMapper() {
        return new MardukMapper();
    }
}
