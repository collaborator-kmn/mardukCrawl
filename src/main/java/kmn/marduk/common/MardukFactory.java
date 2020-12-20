package kmn.marduk.common;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.SQLException;

public interface MardukFactory {
    Connection  getConnection() throws ConnectorException;
    Mapper<Marduk, SQLException> getMapper();

}
