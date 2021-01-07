package kmn.marduk.dao;

import kmn.marduk.entity.Marduk;

import java.util.Date;
import java.util.List;

/** Шлюз для получения данных из БД Oracle по заданному промежутку времени
 */

public interface MardukDAO {
    List<Marduk> get(Date start, Date end);
}