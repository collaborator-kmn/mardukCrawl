package kmn.marduk.common;
import java.sql.ResultSet;

public interface Mapper<T, E extends Throwable> {

    T process(ResultSet rs) throws E;

}