package kmn.marduk.dao;

import kmn.marduk.common.MardukOracleFactory;
import kmn.marduk.db.Connector;
import kmn.marduk.common.Mapper;
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

    MardukOracleFactory mardukFactory;

    public MardukOracleDAO(MardukOracleFactory mardukFactory) {
        this.mardukFactory = mardukFactory;
    }


    public List<Marduk> get(Date start, Date end) {
        List<Marduk> list = null;
        try {

            Connection connection = (Connection) mardukFactory.getConnection().connect();
            PreparedStatement statement = connection.prepareStatement("select * from table");
            ResultSet resultSet = statement.executeQuery();
            {
                list = new ArrayList<>();
//                Mapper<Marduk, SQLException> mapper = new MardukMapper();
                while (resultSet.next()) {
                    list.add((Marduk) mardukFactory.getMapper().process(resultSet));
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
}