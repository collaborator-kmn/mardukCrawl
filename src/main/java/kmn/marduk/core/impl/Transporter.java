package kmn.marduk.core.impl;

import kmn.marduk.common.impl.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.common.processor.ProcessException;
import kmn.marduk.core.Context;
import kmn.marduk.core.TransporterAbstract;
import kmn.marduk.core.TransporterInterface;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;
import kmn.marduk.entity.DataBaseIdentifying;
import kmn.marduk.entity.Marduk;

import java.sql.Date;
import java.util.List;
import java.util.Properties;

public class Transporter extends TransporterAbstract implements TransporterInterface {
    private Properties properties;
    private Date start;
    private Date end;
    private Marduk mardukEntity;

    private Transporter(Properties properties, Date start, Date end){
        this.properties = properties;
        this.start = start;
        this.end = end;
    }
    public void run() throws ProcessException {
        mardukEntity = (Marduk) getContext().getMardukEntity().get(start, end);
        DataBaseIdentifying dataBaseIdentifyingEntity = getContext().getProcess().process(mardukEntity);
        List db = getContext().setDBIdentifying().set(start, end);
    }


    @Override
    public Context getContext() {
        return new ContextImpl(new MardukOracleDAO(new MardukOracleFactory(properties)),
                new DBIdentifyingSQLServerDAO(), new Marduk2DBIdentifyingProcessor());
    }
}
