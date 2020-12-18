package kmn.marduk.core;

import kmn.marduk.common.processor.Processor;
import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.dao.MardukDAO;

import java.util.Date;

public class ContextImpl implements  Context{
    private MardukDAO mardukDAO;
    private DBIdentifyingDAO dbIdentifyingDAO;
    private Processor<?, ?> processor;
    private Date start;
    private Date end;

    public ContextImpl(MardukDAO mardukDAO, DBIdentifyingDAO dbIdentifyingDAO, Processor<?,?> processor,
                       Date start, Date end){
        this.mardukDAO = mardukDAO;
        this.dbIdentifyingDAO = dbIdentifyingDAO;
        this.processor = processor;
        this.start = start;
        this.end = end;

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
    public Processor<?, ?> getProcess() {
       return processor;
    }
}
