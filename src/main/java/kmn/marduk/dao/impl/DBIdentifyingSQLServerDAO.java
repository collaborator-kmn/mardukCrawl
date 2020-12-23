package kmn.marduk.dao.impl;

import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.db.impl.DBConnection;
import kmn.marduk.entity.DataBaseIdentifying;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DBIdentifyingSQLServerDAO implements DBIdentifyingDAO {
    DBConnection dbConnection;

    @Override
    public void put(List<DataBaseIdentifying> list, Date start, Date end) {

        try {
            Connection connection = dbConnection.getConnection();
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

