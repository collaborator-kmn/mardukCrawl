package kmn.marduk.dao.impl;

import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.db.impl.JDBCConnector;
import kmn.marduk.db.impl.SQLServerHandle;
import kmn.marduk.entity.DataBaseIdentifying;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class DBIdentifyingSQLServerDAO implements DBIdentifyingDAO {

    private final JDBCConnector jdbcConnector;

    public DBIdentifyingSQLServerDAO (Properties properties){
        jdbcConnector = new JDBCConnector(new SQLServerHandle(properties));
        
    }

    @Override
    public void put(List<DataBaseIdentifying> list) {

        try {
            Connection connection = jdbcConnector.connect();
            PreparedStatement statement = connection.prepareStatement("insert * into table");

            Iterator<DataBaseIdentifying> iterator = list.iterator(); //??
            while (iterator.hasNext()){
                statement.executeUpdate();
            }
            statement.close();

        } catch (ConnectorException | SQLException e) {
            e.printStackTrace();
        }
    }
}

