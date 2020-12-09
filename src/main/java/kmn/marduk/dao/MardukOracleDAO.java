package kmn.marduk.dao;

import kmn.marduk.db.Connector;
import kmn.marduk.mapper.Mapper;
import kmn.marduk.entity.Marduk;
import kmn.marduk.mapper.MardukMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MardukOracleDAO implements MardukDAO {
    private Connector<Connection> connector;

    //todo: какая здесь фабрика?? Здесь обычный интерфейс, этот класс только знает о соединениии Connection..ему даже неизвестно, что с этим соединением по факту
    public MardukOracleDAO() {
    } //(тут будет фабрика){
//        this.connector = connector; (коннектор в фабрике)}


    public List<Marduk> get(Date start, Date end) {
        List<Marduk> list = null;
        try {
            Connection connection = connector.connect();
            PreparedStatement statement = connection.prepareStatement("select * from table");
            ResultSet resultSet = statement.executeQuery();
            {
                list = new ArrayList<Marduk>();
                Mapper<Marduk, SQLException> mapper = new MardukMapper();
                while (resultSet.next()) {
                    list.add(mapper.process(resultSet));
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}