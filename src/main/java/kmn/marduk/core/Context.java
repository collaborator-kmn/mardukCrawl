package kmn.marduk.core;

import kmn.marduk.common.processor.Processor;
import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

//Контекст(окружение), включает в себя оба шлюза(oracle, sqlserver)
//и маппер преобразующий сущность типа Мардук к сущности БД
//контекст передаём в класс MardukTransporter

public interface  Context {
    MardukDAO getMardukDao();
    DBIdentifyingDAO getDBIdentifyingDao();
    Processor<Marduk, DataBaseIdentifying> getProcess();
}
