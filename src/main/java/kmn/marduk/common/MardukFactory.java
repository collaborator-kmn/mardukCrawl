package kmn.marduk.common;
import kmn.marduk.db.Connector;
import kmn.marduk.db.ConnectorException;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.SQLException;

public interface MardukFactory {

    Connector<Connection> getConnection() ;
    Mapper<Marduk, SQLException> getMapper();

}
