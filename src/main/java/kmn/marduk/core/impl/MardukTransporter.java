package kmn.marduk.core.impl;

import kmn.marduk.common.impl.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.core.Context;
import kmn.marduk.core.AbstractTransporter;
import kmn.marduk.core.InterfaceTransporter;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

import java.sql.Date;
import java.util.List;
import java.util.Properties;

public class MardukTransporter extends AbstractTransporter implements InterfaceTransporter {
    private final Properties properties;
    private final Date start ;
    private final Date end ;
    private Marduk marduk;


    public MardukTransporter(Properties properties, Date start, Date end){
        this.properties = properties;
        this.start = start;
        this.end = end;
    }

    public void run() {
        List<Marduk> listMardukEntity = getContext().getMardukDao().get(start, end);
        List<DataBaseIdentifying> listDataBaseIdentifying = getContext().getDBIdentifyingDao().set(start, end);

        while (listMardukEntity.listIterator().hasNext()){
            try {
                listDataBaseIdentifying.add(getContext().getProcess().process(marduk));
            } catch (ProcessException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected Context getContext() {
        return new ContextImpl(new MardukOracleDAO(new MardukOracleFactory(properties)),
                new DBIdentifyingSQLServerDAO(), new Marduk2DBIdentifyingProcessor());
    }
}
