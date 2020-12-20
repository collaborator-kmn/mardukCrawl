package kmn.marduk.core.impl;

import kmn.marduk.common.processor.Processor;
import kmn.marduk.core.Context;
import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

public class ContextImpl implements Context {
    private MardukDAO mardukDAO;
    private DBIdentifyingDAO dbIdentifyingDAO;
    private Processor<Marduk, DataBaseIdentifying> processor;

    public ContextImpl(MardukDAO mardukDAO, DBIdentifyingDAO dbIdentifyingDAO, Processor<Marduk, DataBaseIdentifying> processor){
        this.mardukDAO = mardukDAO;
        this.dbIdentifyingDAO = dbIdentifyingDAO;
        this.processor = processor;
    }

    @Override
    public MardukDAO getMardukEntity() {
        return mardukDAO;
    }

    @Override
    public DBIdentifyingDAO setDBIdentifying() {
        return dbIdentifyingDAO;
    }

    @Override
    public Processor<Marduk, DataBaseIdentifying> getProcess() {
       return processor;
    }
}
