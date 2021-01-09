package kmn.marduk.common;
import kmn.marduk.core.transformation.resultset2marduk.Mapper;
import kmn.marduk.db.impl.ConnectorException;
import kmn.marduk.entity.Marduk;

import java.sql.Connection;
import java.sql.SQLException;

/**Интерфейс фабрики, производящей подключения к бд и получения мардук-sql маппера
 *
 */

public interface MardukFactory {
    Connection  getConnection() throws ConnectorException;
    Mapper<Marduk, SQLException> getMapper();

}
