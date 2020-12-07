package marduk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class MardukOracleDAO implements MardukDAO{
    private Connector<Connection> connector;
    private Marduk mardukEntity;

    public MardukOracleDAO(Connector<Connection> connector){
        this.connector = connector;
    }

    public List<Marduk> get() {

        List<Marduk> list = null;

        try {
            try {
                (Connection connection = connector.connect()){
                    list = new LinkedList<Marduk>();
                    while (resultSet.next) {
                        long Id = resultSet.getLong("id");
                        list.add(new Marduk());
                    }
                    resultSet.close();
                    statement.close();
                }
            }catch (ConnectorException | SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
    }
}
