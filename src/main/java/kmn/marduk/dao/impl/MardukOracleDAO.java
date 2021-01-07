package kmn.marduk.dao.impl;

import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** Реализация шлюза для получения данных из БД Oracle
 *
 */
public class MardukOracleDAO implements MardukDAO {

    MardukOracleFactory mardukFactory;
    private static final String SQL_SELECT =

           " SELECT " +
                   " * " +
                   " FROM SV.OBN_TABLE "+
                   " LEFT JOIN SV.SIG_TYPE_TABLE ON (TRIM(SV.SIG_TYPE_TABLE.CODE)=TRIM(SV.OBN_TABLE.SIG_TYPE)) "+
                   " LEFT JOIN SV.SIG_SUB_TYPE_TABLE ON (TRIM(SV.SIG_SUB_TYPE_TABLE.CODE)=TRIM(SV.OBN_TABLE.SIG_SUB_TYPE)) "+
                   " LEFT JOIN SV.NET_TABLE ON (SV.NET_TABLE.ID=SV.OBN_TABLE.WHO_IS_NET_ID) "+
                   " WHERE (NOT_HEAR IS NOT NULL) "+
                   " AND (SV.OBN_TABLE.DATE_BEG between to_date(?,'YYYY-MM-DD HH24:MI:SS') AND to_date(?,'YYYY-MM-DD HH24:MI:SS')) "+
                   " AND ((SV.OBN_TABLE.PARENT_ID IS NULL) OR (SV.OBN_TABLE.PARENT_ID=SV.OBN_TABLE.ID)) "+
                   " and ascii(mark) = '1' ";


    public MardukOracleDAO(MardukOracleFactory mardukFactory) {
        this.mardukFactory = mardukFactory;
    }


    public List<Marduk> get(Date start, Date end) {
        List<Marduk> list = null;
        SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try (Connection connection = mardukFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
            statement.setString(1, fmt.format(start));
            statement.setString(2, fmt.format(end));
            ResultSet resultSet = statement.executeQuery();
            {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(mardukFactory.getMapper().process(resultSet));
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
}