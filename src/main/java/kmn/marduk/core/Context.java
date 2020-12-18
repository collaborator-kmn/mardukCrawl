package kmn.marduk.core;

import kmn.marduk.common.processor.Processor;
import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

public interface  Context {
    MardukDAO getMardukEntity();
    DBIdentifyingDAO setDBIdentifying();
    Processor<Marduk, DataBaseIdentifying> getProcess();

}
