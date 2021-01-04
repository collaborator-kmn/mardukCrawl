package kmn.marduk.dao;

import kmn.marduk.entity.DataBaseIdentifying;

import java.util.List;

//Шлюз для подключения к БД SQLServer

public interface DBIdentifyingDAO {
    void put(List<DataBaseIdentifying> list);
}
