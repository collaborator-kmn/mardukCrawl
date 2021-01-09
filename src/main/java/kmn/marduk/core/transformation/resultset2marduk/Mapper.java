package kmn.marduk.core.transformation.resultset2marduk;
import java.sql.ResultSet;

/** Преобразование resultset к типу T
 *
 * @param <T>
 * @param <E>
 */

public interface Mapper<T, E extends Throwable> {

    T process(ResultSet rs) throws E;

}