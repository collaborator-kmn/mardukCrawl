package kmn.marduk.core.transformation.resultset2marduk.impl;

import kmn.marduk.core.transformation.resultset2marduk.Mapper;
import kmn.marduk.entity.Marduk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

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
        marduk.setSIG_TYPE(sigType(resultSet.getString("SIG_TYPE")));
        marduk.setSEANCE(operNumber(resultSet.getString("SEANCE")));
        marduk.setRECEIVER(resultSet.getString("RECEIVER"));
        marduk.setSENDER(resultSet.getString("SENDER"));
        marduk.setWHO_IS(resultSet.getString("WHO_IS"));
        marduk.setREM(resultSet.getString("REM"));
        marduk.setPLACE_COUNTRY(resultSet.getString("PLACE_COUNTRY"));
        marduk.setPLACE_REGION(resultSet.getString("PLACE_REGION"));
        marduk.setPLACE_NAME(resultSet.getString("PLACE_NAME"));
        return marduk;
    }
    
    private String sigType(String s) {
        try {
            Integer.parseInt(s);
            return s;
        }
        catch (Exception e) {
            return null;
        }
    }

    private int operNumber(String str) {

        char[] s = str.toCharArray();
        StringBuilder res = new StringBuilder();

        for (char c : s) {
            if (Character.isDigit(c)) {
                res.append(c);
            }
        }

        return Integer.parseInt(res.toString().length() > 0 ? res.toString() : "0");
    }
}