package kmn.marduk.dao;

import kmn.marduk.common.MardukFactory;
import kmn.marduk.common.MardukOracleFactory;
import kmn.marduk.db.Connector;
import kmn.marduk.common.Mapper;
import kmn.marduk.db.ConnectorException;
import kmn.marduk.db.OracleHandle;
import kmn.marduk.entity.Marduk;
import kmn.marduk.common.MardukMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MardukOracleDAO implements MardukDAO {

    MardukFactory mardukFactory;

    public MardukOracleDAO(MardukFactory mardukFactory) {
        this.mardukFactory = mardukFactory;
    }


    public List<Marduk> get(Date start, Date end) {
        List<Marduk> list = new ArrayList<>();
        try(Connection connection = mardukFactory.getConnection().connect();
            PreparedStatement statement = connection.prepareStatement("select * from table");
            ResultSet resultSet = statement.executeQuery()) {
            {
                Mapper<Marduk, SQLException> mapper = mardukFactory.getMapper();
                while (resultSet.next()) {
                    list.add(mapper.process(resultSet));
                }
                resultSet.close();
                statement.close();
            }
        } catch (ConnectorException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}