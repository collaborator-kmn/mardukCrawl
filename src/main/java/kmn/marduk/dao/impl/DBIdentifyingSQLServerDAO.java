package kmn.marduk.dao.impl;

import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.db.impl.JDBCConnector;
import kmn.marduk.db.impl.SQLServerHandle;
import kmn.marduk.entity.DataBaseIdentifying;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class DBIdentifyingSQLServerDAO implements DBIdentifyingDAO {

    private static final String SQL_SELECT = "insert into Table1(id, date, freq, coun, town, num, oper, anal) " +
            " values ((select max(id)+1 from Table1), ?, ?, ?, ?, ?, ?, '')";

    private final JDBCConnector jdbcConnector;

    public DBIdentifyingSQLServerDAO (Properties properties){
        jdbcConnector = new JDBCConnector(new SQLServerHandle(properties));
        
    }

    @Override
    public void put(List<DataBaseIdentifying> list) {

        try {
            Connection connection = jdbcConnector.connect();
            connection.createStatement().execute("begin transaction");
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
            for (DataBaseIdentifying entity : list) {
                statement.setDate(1, new java.sql.Date(entity.getDate().getTime()));
                statement.setString(2, entity.getFreq());
                statement.setString(3, entity.getCoun());
                statement.setString(4, entity.getTown());
                statement.setString(5, entity.getNum());
                statement.setInt(6, entity.getOper());
                statement.executeUpdate();
            }
            statement.close();
            connection.createStatement().execute("commit");
        } catch (ConnectorException | SQLException e) {
            e.printStackTrace();
        }
    }
}

