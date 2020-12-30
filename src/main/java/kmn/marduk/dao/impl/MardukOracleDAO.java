package kmn.marduk.dao.impl;

import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            Connection connection = mardukFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from table");
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
            System.out.println(e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
}