package kmn.marduk.dao.impl;

import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.db.impl.JDBCConnector;
import kmn.marduk.db.impl.SQLServerHandle;
import kmn.marduk.entity.DataBaseIdentifying;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

/**В классе подключаемся к БД SQLServer
 * и кладём данные из списка полученных сущностей в таблицу SQLServer
 */



public class DBIdentifyingSQLServerDAO implements DBIdentifyingDAO {

    private static final Logger logger = Logger.getLogger(DBIdentifyingDAO.class);

    private static final String SQL_SELECT = "insert into Table1(id, date, freq, coun, town, num, oper, comm, timeid, anal) " +
            " values ((select max(id)+1 from Table1), ?, ?, ?, ?, ?, ?, ?, ?, '')";

    private final JDBCConnector jdbcConnector;

    public DBIdentifyingSQLServerDAO (Properties properties){
        jdbcConnector = new JDBCConnector(new SQLServerHandle(properties));
        
    }

    @Override
    public void put(List<DataBaseIdentifying> list) {
        if (list != null && list.size() > 0) {
            try (Connection connection = jdbcConnector.connect()) {
                connection.createStatement().execute("begin transaction");
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
                for (DataBaseIdentifying entity : list) {
                    statement.setTimestamp(1, Timestamp.valueOf(entity.getDate()));
                    statement.setString(2, entity.getFreq());
                    statement.setString(3, entity.getCoun());
                    statement.setString(4, entity.getTown());
                    statement.setString(5, entity.getNum());
                    statement.setInt(6, entity.getOper());
                    statement.setString(7, entity.getComm());
                    statement.setString(8, "1900-01-01 " + entity.getDate().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                    statement.executeUpdate();
                }
                statement.close();
                connection.createStatement().execute("commit");
            } catch (ConnectorException | SQLException e) {
                logger.log(Level.ERROR, "Error to put fields in DBIdentifying");
                e.printStackTrace();
            }
        } else {
            logger.log(Level.ERROR, "Список пуст!");
        }
    }
}

