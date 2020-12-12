package kmn.marduk.common;

import kmn.marduk.db.*;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.SQLException;


public class MardukOracleFactory implements MardukFactory{

    public MardukOracleFactory(){
    }

    @Override
    public Connector<Connection> getConnection() {
        return new MardukConnection();
    }

    @Override
    public Mapper<Marduk, SQLException> getMapper() {
        return new MardukMapper();
    }

}
