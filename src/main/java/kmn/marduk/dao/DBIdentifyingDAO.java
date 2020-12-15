package kmn.marduk.dao;

import kmn.marduk.entity.DataBaseIdentifying;

import java.util.Date;
import java.util.List;

public interface DBIdentifyingDAO {
    List<DataBaseIdentifying> set(Date start, Date end);
}
