package kmn.marduk.core.impl;

import kmn.marduk.common.impl.Marduk2DBIdentifyingProcessor;
import kmn.marduk.common.impl.MardukOracleFactory;
import kmn.marduk.core.Context;
import kmn.marduk.core.MardukTransporter;
import kmn.marduk.core.InterfaceTransporter;
import kmn.marduk.dao.impl.DBIdentifyingSQLServerDAO;
import kmn.marduk.dao.impl.MardukOracleDAO;

import java.sql.Date;
import java.util.Properties;

public class Transporter extends MardukTransporter implements InterfaceTransporter {
    private final Properties properties;
    private final Date start;
    private final Date end;

    private Transporter(Properties properties, Date start, Date end){
        this.properties = properties;
        this.start = start;
        this.end = end;
    }
    public void run() {

    }


    @Override
    public Context getContext() {
        return new ContextImpl(new MardukOracleDAO(new MardukOracleFactory(properties)),
                new DBIdentifyingSQLServerDAO(), new Marduk2DBIdentifyingProcessor());
    }
}
