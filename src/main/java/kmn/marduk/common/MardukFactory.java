package kmn.marduk.common;
import kmn.marduk.db.Connector;

public interface MardukFactory {
    Connector getConnection();
    Mapper getMapper();

}
