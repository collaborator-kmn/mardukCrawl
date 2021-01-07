package kmn.marduk.core.impl;

import kmn.marduk.common.processor.Processor;
import kmn.marduk.core.Context;
import kmn.marduk.dao.DBIdentifyingDAO;
import kmn.marduk.dao.MardukDAO;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;
import org.apache.log4j.Logger;


/**Реализация контекста
  */
public class ContextImpl implements Context {
    private static final Logger logger = Logger.getLogger(Context.class);

    private MardukDAO mardukDAO;
    private DBIdentifyingDAO dbIdentifyingDAO;
    private Processor<Marduk, DataBaseIdentifying> processor;

    public ContextImpl(MardukDAO mardukDAO, DBIdentifyingDAO dbIdentifyingDAO, Processor<Marduk, DataBaseIdentifying> processor
                       ){
        this.mardukDAO = mardukDAO;
        this.dbIdentifyingDAO = dbIdentifyingDAO;
        this.processor = processor;
        logger.info("Context created");
    }

    @Override
    public MardukDAO getMardukDao() {
        return mardukDAO;
    }

    @Override
    public DBIdentifyingDAO getDBIdentifyingDao() {
        return dbIdentifyingDAO;
    }

    @Override
    public Processor<Marduk, DataBaseIdentifying> getProcess() {
       return processor;
    }

}
