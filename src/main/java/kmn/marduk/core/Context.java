package kmn.marduk.core;

import kmn.marduk.common.processor.Processor;
import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.dao.MardukDAO;

public interface Context {
    MardukDAO getMardukEntity();
    DBIdentifyingDAO setDBIdentifying();
    Processor<?, ?> getProcess();

}
