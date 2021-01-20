package kmn.marduk.dao.impl;

import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.Marduk;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** Реализация шлюза для получения данных из БД Oracle
 *
 */
public class MardukOracleDAO implements MardukDAO {

    private static final Logger logger = Logger.getLogger(MardukDAO.class);

    MardukOracleFactory mardukFactory;
    private static final String SQL_SELECT =

           " SELECT " +
                   " * " +
                   " FROM SV.OBN_TABLE "+
                   " LEFT JOIN SV.SIG_TYPE_TABLE ON (TRIM(SV.SIG_TYPE_TABLE.CODE)=TRIM(SV.OBN_TABLE.SIG_TYPE)) "+
                   " LEFT JOIN SV.SIG_SUB_TYPE_TABLE ON (TRIM(SV.SIG_SUB_TYPE_TABLE.CODE)=TRIM(SV.OBN_TABLE.SIG_SUB_TYPE)) "+
                   " LEFT JOIN SV.NET_TABLE ON (SV.NET_TABLE.ID=SV.OBN_TABLE.WHO_IS_NET_ID) "+
                   " WHERE (NOT_HEAR IS NOT NULL) "+
                   " AND (SV.OBN_TABLE.DATE_BEG between ? AND ?) "+
                   " AND ((SV.OBN_TABLE.PARENT_ID IS NULL) OR (SV.OBN_TABLE.PARENT_ID=SV.OBN_TABLE.ID)) "+
                   " and (ascii(SV.OBN_TABLE.SEANCE) is not null) ";


    public MardukOracleDAO(MardukOracleFactory mardukFactory) {
        this.mardukFactory = mardukFactory;
    }


    public List<Marduk> get(Date start, Date end) {
        logger.info("Date start: "+ start);
        logger.info("Date end: "+ end);
        List<Marduk> list = null;
        SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try (Connection connection = mardukFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
            statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault())));
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.ofInstant(end.toInstant(), ZoneId.systemDefault())));
            ResultSet resultSet = statement.executeQuery();
            {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(mardukFactory.getMapper().process(resultSet));
                }
                resultSet.close();
                statement.close();
            }
            logger.info("List size: " + list.size());
        } catch (Exception e) {
           logger.log(Level.ERROR, "Error to get fields from MardukOracle");
           e.printStackTrace();
        } 
        return list;
    }
}