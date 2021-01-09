package kmn.marduk.core.transformation.resultset2marduk.impl;

import kmn.marduk.core.transformation.resultset2marduk.Mapper;
import kmn.marduk.entity.Marduk;

import java.sql.ResultSet;
import java.sql.SQLException;

/**Класс, преобразующий SQL Resultset к типу Мардук
 *
 */

public class MardukMapper implements Mapper<Marduk, SQLException> {

    public Marduk process(ResultSet resultSet) throws SQLException {
        Marduk marduk = new Marduk();
        marduk.setDATE_BEG(resultSet.getTimestamp("DATE_BEG").toLocalDateTime());
        marduk.setFREQ_HZ(resultSet.getString("FREQ_HZ"));
        marduk.setWHO_IS_COUNTRY(resultSet.getString("WHO_IS_COUNTRY"));
        marduk.setWHO_IS_BRANCH(resultSet.getString("WHO_IS_BRANCH"));
        marduk.setSIG_TYPE(resultSet.getString("SIG_TYPE").equals("--------") ? null : resultSet.getString("SIG_TYPE"));
        marduk.setSEANCE(resultSet.getInt("SEANCE"));
//        marduk.setTO(resultSet.getString("to"));
//        marduk.setFROM(resultSet.getString("from"));
        return marduk;
    }
}