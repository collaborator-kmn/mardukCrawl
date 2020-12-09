package marduk;

import api.connector.Connector;
import api.connector.ConnectorException;
import marduk.entity.Marduk;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MardukOracleDAO implements MardukDAO {
    private Connector<Connection> connector;

    public MardukOracleDAO() {
    } //(тут будет фабрика){
//        this.connector = connector; (коннектор в фарбрике)}


    public List<Marduk> get(Date start, Date end) {
        List<Marduk> list = null;
        try {
            try {
                Connection connection = connector.connect();
                PreparedStatement statement = connection.prepareStatement();
                ResultSet resultSet = statement.executeQuery();
                {
                    list = new ArrayList<Marduk>();
                    Mapper<Marduk, SQLException> mapper = new MardukMapper();
                    while (resultSet.next) {
                        list.add(mapper.process(resultSet));
                    }
                    resultSet.close();
                    statement.close();
                }
            } catch (ConnectorException | SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
    }

}
