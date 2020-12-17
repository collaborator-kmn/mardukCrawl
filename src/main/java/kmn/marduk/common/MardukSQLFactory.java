package kmn.marduk.common;
import kmn.marduk.db.ConnectorException;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.SQLException;

public interface MardukSQLFactory {
    Connection  getConnection() throws ConnectorException;
    Mapper<Marduk, SQLException> getMapper();

}
