package kmn.marduk.common.impl;

import kmn.marduk.common.Mapper;
import kmn.marduk.entity.Marduk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MardukMapper implements Mapper<Marduk, SQLException> {

    public Marduk process(ResultSet resultSet) throws SQLException {
        Marduk marduk = new Marduk();
        marduk.setDATE_REG(resultSet.getDate("date"));
        marduk.setFREQ_HZ(resultSet.getString("frequency"));
        marduk.setWHO_IS_COUNTRY(resultSet.getString("town"));
        marduk.setWHO_IS_BRANCH(resultSet.getString("country"));
        marduk.setSIG_TYPE(resultSet.getString("erbd_number"));
        marduk.setSEANCE(resultSet.getInt("operator"));
        marduk.setTO(resultSet.getString("to"));
        marduk.setFROM(resultSet.getString("from"));
        return marduk;
    }
}